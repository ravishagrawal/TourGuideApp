package com.example.android.tourguideapp;

/**
 * Created by hp on 28-05-2017.
 */

public class Word {
    private String mPlaceName;

    private String mAddress;

    private String mTime;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;



    public Word (String PlaceName, String Address, String Time ) {

        mTime= Time;
        mPlaceName= PlaceName;
        mAddress= Address;
    }

    public Word (String PlaceName, String Address, String Time, Integer ImageResourceId ) {

        mTime= Time;
        mPlaceName= PlaceName;
        mAddress= Address;
        mImageResourceId= ImageResourceId;
    }

    public String getPlaceName () {

        return mPlaceName;
    }

    public String getAddress () {

        return mAddress;
    }

    public Integer getImageResourceId () {

        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getTime () {

        return mTime;
    }
}
