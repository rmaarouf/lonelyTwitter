package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Abstract class tweet contains the tweet message and date inputted.
 *
 * @author Reem
 */
public abstract class Tweet implements Tweetable{
    private String message;
    private Date date;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }
    @Override
    public String toString()
    {
        return message;
    }


    public abstract Boolean isImportant();


    /**
     * Message cannot be longer than 140 characters. Exception is thrown if message is longer.
     *
     * @param message the text that is inputted
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            //Do Something!
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }



}
