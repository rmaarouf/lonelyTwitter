package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/15/16.
 *
 * This method extends the abstract class tweet.
 *
 * @author Reem
 */
public class NormalTweet extends Tweet{

    public NormalTweet(String message) {
        super(message);
    }

    /**
     *
     * @return the value false because it is a normal tweet and not important.
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }




}
