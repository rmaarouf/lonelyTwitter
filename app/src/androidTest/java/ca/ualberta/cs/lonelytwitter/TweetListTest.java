package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Reem on 2016-09-29.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2
{


    public TweetListTest()
    {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }


    public void testAddTweet()
    {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        try
        {
            tweets.add(tweet);
        }
        catch(IllegalArgumentException e)
        {
            assertTrue(tweets.hasTweet(tweet));
        }
    }

    public void testHasTweet()
    {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testDelete()
    {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");

        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.hasTweet(tweet));
    }

    public void testGetTweet()
    {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testGetTweets()
    {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("test 1");
        Tweet tweet2 = new NormalTweet("test 2");
        Tweet tweet3 = new NormalTweet("test 3");
        tweets.add(tweet2);
        tweets.add(tweet3);
        tweets.add(tweet1);

        TweetList orderedTweets = tweets.getTweets();


        assertEquals(orderedTweets.getTweet(0).getDate(), tweet1.getDate());
        assertEquals(orderedTweets.getTweet(1).getDate(), tweet2.getDate());
        assertEquals(orderedTweets.getTweet(2).getDate(),tweet3.getDate());

    }

    //simplescreenrecorder
    public void testGetCount()
    {
        TweetList tweets = new TweetList();
        tweets.add(new NormalTweet("test 1"));
        tweets.add(new NormalTweet("test 2"));
        tweets.add(new NormalTweet("test 3"));
        int count = tweets.getCount();
        assertEquals(count, 3);
    }

}
