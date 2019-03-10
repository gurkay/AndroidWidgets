package com.test.androidwidgets;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

///////////////////////////////////////////////////////////////
//
// Share Global Data Information Using
//
///////////////////////////////////////////////////////////////

public class SharedData {


    ///////////////////////////////////////////////////////////////
    //
    // Private Variables
    //
    ///////////////////////////////////////////////////////////////

    private String[] spinnerPassingActivityString = {"Select Activity", "Main Activity",
            "Second Activity", "Three Activity", "Four Activity", "Five Activity", "Six Activity"};
    // Current Activity
    private Activity myCurrentActivity = null;

    ///////////////////////////////////////////////////////////////
    //
    // Spinner Passing Activity String Array
    //
    ///////////////////////////////////////////////////////////////

    protected String[] getSpinnerPassingActivityString(){
        return spinnerPassingActivityString;
    }

    private String getSpinnerPassingActivityString(int position){
        return spinnerPassingActivityString[position];
    }

    ///////////////////////////////////////////////////////////////
    //
    // Spinner Activity Passing Navigator
    //
    ///////////////////////////////////////////////////////////////

    protected void setSpinnerNavigation(int position, int parentGetId) {
        String activityName = myCurrentActivity.getClass().getSimpleName();

        if (parentGetId == R.id.spinnerPassingActivity) {
            switch (position){
                case 0:
                    Toast.makeText(getMyCurrentActivity(), getSpinnerPassingActivityString(position), Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    if (activityName.equalsIgnoreCase("MainActivity")) {
                        Toast.makeText(getMyCurrentActivity(), activityName, Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentMainActivity = new Intent(getMyCurrentActivity(), MainActivity.class);
                        getMyCurrentActivity().startActivity(intentMainActivity);
                    }
                    break;
                case 2:
                    if (activityName.equalsIgnoreCase("SecondActivity")) {
                        Toast.makeText(getMyCurrentActivity(), activityName, Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentSecondActivity = new Intent(getMyCurrentActivity(), SecondActivity.class);
                        getMyCurrentActivity().startActivity(intentSecondActivity);
                    }
                    break;
                case 3:
                    if (activityName.equalsIgnoreCase("ThreeActivity")) {
                        Toast.makeText(getMyCurrentActivity(), activityName, Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentThreeActivity = new Intent(getMyCurrentActivity(), ThreeActivity.class);
                        getMyCurrentActivity().startActivity(intentThreeActivity);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    ///////////////////////////////////////////////////////////////
    //
    // Current Activity SET - GET Methods
    //
    ///////////////////////////////////////////////////////////////

    private Activity getMyCurrentActivity() {
        return myCurrentActivity;
    }

    protected void setMyCurrentActivity(Activity myCurrentActivity) {
        this.myCurrentActivity = myCurrentActivity;
    }
}
