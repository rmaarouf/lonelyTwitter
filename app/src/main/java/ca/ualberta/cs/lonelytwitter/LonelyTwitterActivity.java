/*
Copyright (C) 2016 Team 15, COMPUT 301, University of Alberta - All Rights Reserved
You may use, copy or redistribute this code under terms and conditions of Uiversity of Alberta
and Code of Student Behavior.
Please contact rmaarouf@ualberta.ca for more details and questions.
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 *  This class is the main class view class in lonelyTwitter class.
 *  It deals with user inputs, saves and loads them in/from the file FILE_NAME (file.sav).
 *
 *  @author Reem
 *  @version 1.4
 *  @see NormalTweet
 *  @see java.io.BufferedReader
 *
 */

public class LonelyTwitterActivity extends Activity {

	/**
	 * This is the name of the file that is saved in your virtual device.
	 * You can access it through Android Device by selecting your app
	 * then data -> data -> file.sav.
	 *
	 * @see NormalTweet
	 */
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/*
	Testing mutli-line documentations. Testing.
	 */

	/** Called when the activity is first created. */
	/**
	 *
	 * Function is called when activity is first created. The onCreate function
	 * uses an adapter to display the tweets inputted from the user onto the screen. The
	 * tweets will be displayed in a list format from newest inserted tweet to the oldest.
	 *
	 * <p>
	 *     On the main activity, two buttons will be created and implemented.
	 *     The save button will be in change of saving the inputted tweet into the
	 *     tweet list. The clear button will clear all tweets that are contained in the
	 *     tweet list.
	 * </p>
	 *
	 * @param savedInstanceState the instance of the saved state
	 *
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


		// sets save button that when is clicked to append the tweet into the tweet list.
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet newTweet = new NormalTweet(text);
				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

		// sets clear button to clear all inputs from the tweetlist.
		clearButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				setResult(RESULT_OK);
				tweetList.clear();
				adapter.clear();

			}
		});
	}

	/**
	 *
	 * Method that is called after the activity display is created. This method sets the
	 * array adapter to list of tweets.
	 *
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * This method loads the contents of the file into an arraylist of tweets. This method
	 * uses JSON to load data from the file into an arraylist object. A filestream is opened and reads
	 * the file FILE_NAME.
	 *
	 *	@throws RuntimeException
	 *	@exception FileNotFoundException
	 *	@exception IOException
	 *
	 *
	 */
	private void loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Code taken from stackOverFlow http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Sept 22,2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}

	}

	/**
	 * This method saves the arraylist of tweets into the json file. It opens a file output stream
	 * and writes to the file stream using an <code>OutputStreamWriter</code> object. A new Gson object
	 * is created and is converted to
	 *
	 *
	 * @throws  RuntimeException
	 * @exception FileNotFoundException
	 * @exception  IOException
	 */

	private void saveInFile() {
		try {

			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweetList, writer);
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}