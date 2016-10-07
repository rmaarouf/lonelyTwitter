package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/15/16.
 *
 * @author Reem
 *
 */

/**
 *
 * This class extends the abstract class tweet.
 */
public class ImportantTweet extends Tweet{

    public ImportantTweet(String message){
        super(message);
    }

    /**
     *
     * @return the value true because it is important
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }




}
