package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Reem on 2016-09-15.
 */
public class ImportantTweets extends Tweet
{
    public ImportantTweets(String message)
    {
        super(message);
    }

    @Override
    public Boolean isImportant()
    {
        return Boolean.TRUE;
    }


}
