package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Reem on 2016-09-15.
 */
public class HappyMood extends CurrentMood {

    public HappyMood()
    {
        super();
    }

    public HappyMood(Date date)
    {
        super(date);
    }

    @Override
    public String myMood()
    {
        return "Happy";
    }
}
