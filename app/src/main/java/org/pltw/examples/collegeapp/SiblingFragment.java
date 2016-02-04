package org.pltw.examples.collegeapp;

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
public class SiblingFragment extends Fragment {
    private static final String KEY_FIRST_NAME = "firstname";
    private final String FILENAME = "sibling.json";

    private static final String TAG = "SiblingFragment";
    private Sibling mSibling;
    private TextView mFirstName;
    private TextView mLastName;
    private EditText mEnterFirstName;
    private EditText mEnterLastName;
    private Context mAppContext;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian, container, false);

        mSibling = new Sibling();
        mSibling = (Sibling)Family.get().getFamily().get(getActivity().
                getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,1));

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        mEnterFirstName = (EditText)rootView.findViewById(R.id.enter_first_name);
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        mEnterLastName = (EditText)rootView.findViewById(R.id.enter_last_name);

        mFirstName.setText(mSibling.getFirstName());
        mLastName.setText(mSibling.getLastName());

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
            mSibling.setFirstName(s.toString());
            ArrayList<FamilyMember> family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,1);
            family.set(index, (FamilyMember) mSibling);
        }


        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mSibling.getFirstName());
        }
    }

    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mSibling.setLastName(s.toString());
            ArrayList<FamilyMember> family = Family.get().getFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,1);
            family.set(index, (FamilyMember)mSibling);
        }


        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mSibling.getLastName());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        try {

            Log.d(TAG, "Loaded " + mSibling.getFirstName());
            mFirstName.setText(mSibling.getFirstName());
            mLastName.setText(mSibling.getLastName());

        } catch (Exception e) {
            mSibling = new Sibling();
            Log.e(TAG, "Error loading profile from: " + FILENAME, e);
        }
        Log.d(TAG, "Fragment resumed.");
    }



    public SiblingFragment() {
        try {


        } catch (Exception e) {
            mSibling = new Sibling();
            Log.e(TAG, "Error loading profile: " + FILENAME, e);
        }
    }

}
