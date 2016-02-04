package org.pltw.examples.collegeapp;

import android.content.Context;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by PLTW on 12/3/2015.
 */
public abstract class JSONStorer {
    protected Context mContext;
    protected String mFilename;
    private static final int PROFILE = 0;
    private static final int GUARDIAN = 0;


    public JSONStorer() {}

    public JSONStorer(Context c, String f) {
        mContext = c;
        mFilename = f;
    }

    public abstract ApplicantData load(Profile profile) throws IOException, JSONException;
    public abstract void save(ApplicantData applicantData) throws JSONException,
            IOException;

}