package com.rq.golfscorecard.model;

/**
 * Created by Faydee on 2018/2/28.
 */

public class Hole {
    private String title;
    private int strokeCount;

    public Hole(String title, int strokeCount) {
        this.title = title;
        this.strokeCount = strokeCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStrokeCount() {
        return strokeCount;
    }

    public void setStrokeCount(int strokeCount) {
        this.strokeCount = strokeCount;
    }
}
