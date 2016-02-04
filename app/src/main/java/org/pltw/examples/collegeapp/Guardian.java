package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by wdumas on 2/11/2015.
 */
public class Guardian extends FamilyMember implements ApplicantData {


    public Guardian(){
        setFirstName("Roger");
        setLastName("Dumas");
        setOccupation("unknown");

    }

    public Guardian(String firstname, String lastname, String occupation){
        super();
        setFirstName(firstname);
        setLastName(lastname);
        setOccupation(occupation);
        setRelation(super.GUARDIAN);

    }


    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FIRST_NAME, mFirstName);
        json.put(JSON_LAST_NAME, mLastName);
        json.put(JSON_OCCUPATION, mOccupation);
        return json;
    }

    public String toString() {
        return "Guardian: " + mFirstName + " " + mLastName + "\n" + "Occupation: " + mOccupation;
    }

    public Guardian(JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mLastName = json.getString(JSON_LAST_NAME);
        mOccupation = json.getString(JSON_OCCUPATION);
    }


}
