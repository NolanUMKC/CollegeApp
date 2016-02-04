package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by PLTW on 1/7/2016.
 */
public class Sibling extends FamilyMember{


    public Sibling(){
        setFirstName("Sarah");
        setLastName("Banana");
        setAge("15");
        setRelation(super.SIBLING);
    }

    public Sibling(String firstname, String lastname, String age){
        super();
        setFirstName(firstname);
        setLastName(lastname);
        setAge(age);
        setRelation(super.SIBLING);

    }



    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FIRST_NAME, mFirstName);
        json.put(JSON_LAST_NAME, mLastName);
        json.put(JSON_AGE, mAge);
        return json;
    }

    public String toString() {
        return "Sibling: " + mFirstName + " " + mLastName + "\n" + "Age: " + mAge;
    }

    public Sibling(JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mLastName = json.getString(JSON_LAST_NAME);
        mAge = json.getString(JSON_AGE);
    }


}
