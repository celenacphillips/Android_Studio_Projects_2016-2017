package com.example.android.miwok;

/**
 * Created by celena on 8/28/2017.
 */

public class Word {
    private String english, miwok;
    private int imageResourceID;
    private boolean visible;
    private int audioResourceID;

    public Word (String englishWord, String miwokWord, int audioResourceId) {
        english = englishWord;
        miwok = miwokWord;
        visible = false;
        audioResourceID = audioResourceId;
    }

    public Word (String englishWord, String miwokWord, int imageResourceId, int audioResourceId) {
        english = englishWord;
        miwok = miwokWord;
        imageResourceID = imageResourceId;
        visible = true;
        audioResourceID = audioResourceId;
    }

    public String getEnglish () {
        return english;
    }

    public String getMiwok () {
        return miwok;
    }

    public int getImageResourceID () {
        return imageResourceID;
    }

    public boolean getVisibility () {
        return visible;
    }

    public int getAudioResourceID () {
        return audioResourceID;
    }
}
