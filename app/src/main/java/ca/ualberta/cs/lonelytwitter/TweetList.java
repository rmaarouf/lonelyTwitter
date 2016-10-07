package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class that is a tweet list.
 *
 * @author Reem
 *
 */
public class TweetList
{

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList()
    {

    }

    /**
     *
     * @param tweetlist
     */
    public TweetList(ArrayList<Tweet> tweetlist)
    {
        this.tweets = tweetlist;
    }


    /**
     *
     * @param tweet
     * @return
     */
    public boolean hasTweet(Tweet tweet)
    {
        return tweets.contains(tweet);
    }

    /**
     *
     * @param tweet
     */
    public void add(Tweet tweet)
    {
        tweets.add(tweet);
    }

    /**
     *
     * @param tweet
     */

    public void delete(Tweet tweet)
    {
        tweets.remove(tweet);
    }

    /**
     *
     * @param index the index of a tweet in the tweet list
     * @return tweet with specific index
     */
    public Tweet getTweet(int index)
    {
        return tweets.get(index);
    }

    /**
     *
     * @return the size of the tweet list
     */
    public int getCount()
    {
        return tweets.size();
    }

    /**
     *
     * @return list of tweets in order of date inputted
     */
    public TweetList getTweets()
    {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.getDate().compareTo(rhs.getDate());
            }
        });
        return this;
    }
}
