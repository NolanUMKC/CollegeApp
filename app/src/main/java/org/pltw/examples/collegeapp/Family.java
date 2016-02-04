package org.pltw.examples.collegeapp;

import java.util.ArrayList;

/**
 * Created by PLTW on 12/11/2015.
 */
public class Family {

    private static final String TAG = Family.class.getName();
    ArrayList<FamilyMember> mFamily;
    private static Family sFamily;

    private Family() {
        mFamily = new ArrayList<FamilyMember>();
        mFamily.add(new Guardian());
        mFamily.add(new Guardian("Mike", "Banana", "Teacher"));
        mFamily.add(new Sibling("Sarah", "Banana", "15"));
    }

    public static Family get(){
        if (sFamily == null);
        sFamily = new Family();
        return sFamily;
    }

    public ArrayList<FamilyMember> getFamily() {
        return mFamily;
    }

    public void setFamily(ArrayList<FamilyMember> family) {
        mFamily = family;
    }

    public void deleteFamilyMember(FamilyMember familyMember) {
    }

    public void addFamilyMember(FamilyMember familymember) {
    }
}
