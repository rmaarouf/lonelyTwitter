package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Reem on 2016-09-15.
 */
public class SadMood extends CurrentMood{

    public SadMood()
    {
        super();
    }

    public SadMood(Date date)
    {
        super(date);
    }

    @Override
    public String myMood()
    {
        return "Sad";
    }


}
