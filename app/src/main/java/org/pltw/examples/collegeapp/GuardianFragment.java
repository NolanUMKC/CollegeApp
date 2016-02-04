package org.pltw.examples.collegeapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wdumas on 2/18/2015.
 */
public class GuardianFragment extends FamilyMemberFragment {
    private static final String KEY_FIRST_NAME = "firstname";
    private final String FILENAME = "guardian.json";

    private static final String TAG = "GuardianFragment";
    private Guardian mGuardian;
    private TextView mFirstName;
    private TextView mLastName;
    private EditText mEnterFirstName;
    private EditText mEnterLastName;
    private Context mAppContext;
    Profile mProfile;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian, container, false);

        mGuardian = new Guardian();
        mGuardian = (Guardian)Family.get().getFamily().get(getActivity().
                getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0));

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        mEnterFirstName = (EditText)rootView.findViewById(R.id.enter_first_name);
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        mEnterLastName = (EditText)rootView.findViewById(R.id.enter_last_name);

        mFirstName.setText(mGuardian.getFirstName());
        mLastName.setText(mGuardian.getLastName());

        FirstNameTextChanger firstNameTextChanger = new FirstNameTextChanger();
        LastNameTextChanger lastNameTextChanger = new LastNameTextChanger();

        mEnterFirstName.addTextChangedListener(firstNameTextChanger);

        mAppContext = this.getActivity();
        Log.d(TAG, "Context: " + mAppContext);


        mEnterLastName.addTextChangedListener(lastNameTextChanger);
        return rootView;
    }




    private class FirstNameTextChanger implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGuardian.setFirstName(s.toString());
            ArrayList<FamilyMember> family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0);
            family.set(index, (FamilyMember) mGuardian);
        }


        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mGuardian.getFirstName());
        }
    }

    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGuardian.setLastName(s.toString());
            ArrayList<FamilyMember> family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0);
            family.set(index, (FamilyMember)mGuardian);
        }


        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mGuardian.getLastName());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment started.");
    }



    public GuardianFragment() {
        try {


        } catch (Exception e) {
            mGuardian = new Guardian();
            Log.e(TAG, "Error loading profile: " + FILENAME, e);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment paused.");
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            Log.d(TAG, "Loaded " + mGuardian.getFirstName());
            mFirstName.setText(mGuardian.getFirstName());
            mLastName.setText(mGuardian.getLastName());

        } catch (Exception e) {
            mGuardian = new Guardian();
            Log.e(TAG, "Error loading profile from: " + FILENAME, e);
        }
        Log.d(TAG, "Fragment resumed.");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment stopped.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment destroyed.");
    }

}