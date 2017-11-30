package com.example.poison101.edutrack;

import java.io.Serializable;

/**
 * Created by CodeTride on 2017/08/14.
 */

public class ContactRecycler implements Serializable {
    private String mName, mSurname, mFeedback, mTerm;
    private int mImage;

    public ContactRecycler() {
    }

    public ContactRecycler(String mName, String mSurname, String mFeedback, String mTerm) {
        this.mName = mName;
        this.mSurname = mSurname;
        this.mFeedback = mFeedback;
        this.mTerm = mTerm;
    }

    public ContactRecycler(String mName, String mSurname, int mImage) {
        this.mName = mName;
        this.mSurname = mSurname;
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String mSurname) {
        this.mSurname = mSurname;
    }

    public String getmFeedback() {
        return mFeedback;
    }

    public void setmFeedback(String mFeedback) {
        this.mFeedback = mFeedback;
    }

    public String getmTerm() {
        return mTerm;
    }

    public void setmTerm(String mTerm) {
        this.mTerm = mTerm;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
}