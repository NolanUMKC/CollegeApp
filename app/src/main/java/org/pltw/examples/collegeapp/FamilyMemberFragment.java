package org.pltw.examples.collegeapp;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by PLTW on 1/20/2016.
 */
public class FamilyMemberFragment extends Fragment {
    private static final String TAG = "FamilyMemberFragment";

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment started.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment paused.");
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

