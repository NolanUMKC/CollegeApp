package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by PLTW on 12/10/2015.
 */
public abstract class FamilyMember implements ApplicantData, Comparable<FamilyMember>  {

    protected static final String JSON_FIRST_NAME = "firstName";
    protected static final String JSON_LAST_NAME = "lastName";
    protected static final String JSON_OCCUPATION = "occupation";
    protected static final String JSON_AGE = "age";
    public static final String EXTRA_RELATION = "org.pltw.examples.collegeapp.relation";
    public static final String EXTRA_INDEX = "org.pltw.examples.collegeapp.index";
    protected String mFirstName;
    protected String mLastName;
    protected String mOccupation;
    protected String mAge;
    public static final int GUARDIAN = 0;
    public static final int SIBLING = 1;
    private int mRelation;
    public FamilyMember(){
    }


    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getOccupation() { return mOccupation; }

    public void setOccupation(String occupation) { mOccupation = occupation; }

    public String getAge() { return mAge; }

    public void setAge(String age) { mAge = age; }

    public int getRelation() {
        return mRelation;
    }

    public void setRelation(int relation) {
        mRelation = relation;
    }

    public FamilyMember (JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mLastName = json.getString(JSON_LAST_NAME);
        mOccupation = json.getString(JSON_OCCUPATION);
        mAge = json.getString(JSON_AGE);
    }

    @Override
    public int compareTo(FamilyMember another) {
        if (getFirstName().equals(getLastName())) {
            return 0;
        } else {
            return 1;
        }
    }
}

