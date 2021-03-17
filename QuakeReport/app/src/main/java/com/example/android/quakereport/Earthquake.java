package com.example.android.quakereport;

/**
 * Created by celena on 9/25/2017.
 */

public class Earthquake {
    private String location;
    private long timeInMilliseconds;
    private double magnitude;
    private String url;

    public Earthquake (double mag, String loc, long timeInMS, String webURL) {
        magnitude = mag;
        location = loc;
        timeInMilliseconds = timeInMS;
        url = webURL;
    }

    public double getMagnitude () {
        return magnitude;
    }

    public String getLocation () {
        return  location;
    }

    public long getTimeInMilliseconds () {
        return timeInMilliseconds;
    }

    public String getUrl () {
        return  url;
    }
}
