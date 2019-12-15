package com.example.note;

public class Word {

    /** Default translation for the word*/
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Image Resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIEDED;

    private static final int NO_IMAGE_PROVIEDED = -1;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     *
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }

    /**
     *Get the default translation of the word,
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Get the default translation of the word,
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**Image resource IDfor the words*/
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /**  Return whether or not ther eis an image for this word*/
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIEDED;
    }
}
