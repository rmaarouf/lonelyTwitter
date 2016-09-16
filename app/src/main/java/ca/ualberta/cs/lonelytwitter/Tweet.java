package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Reem on 2016-09-15.
 */
public abstract class Tweet
{

    private String message;
    private Date date;

    private ArrayList<CurrentMood> moods;

    public ArrayList<CurrentMood> getMoods() {
        return moods;
    }

    public void setMoods(ArrayList<CurrentMood> moods) {
        this.moods = moods;
    }


    public Tweet(String message)
    {
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date)
    {
        this.message = message;
        this.date = date;
    }

    public String getMessage()
    {
        return message;
    }

    public abstract Boolean isImportant();

    public void setMessage(String message) throws TweetTooLongException
    {
        if (message.length() > 140)
        {
            // Do something!
            throw new TweetTooLongException();
        }
        this.message = message;
    }


    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

}
