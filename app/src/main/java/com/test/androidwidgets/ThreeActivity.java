package com.test.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ThreeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ///////////////////////////////////////////////////////////////
    //
    // Widget Components
    //
    ///////////////////////////////////////////////////////////////

    Spinner spinnerPassingActivity;

    ///////////////////////////////////////////////////////////////
    //
    // Variables
    //
    ///////////////////////////////////////////////////////////////

    SharedData sharedData = new SharedData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        ///////////////////////////////////////////////////////////////
        //
        // Spinner Activity Passing Component Using
        //
        ///////////////////////////////////////////////////////////////

        spinnerPassingActivity = findViewById(R.id.spinnerPassingActivity);
        spinnerPassingActivity.setOnItemSelectedListener(this);
        ArrayAdapter adapterSpinnerActivity = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sharedData.getSpinnerPassingActivityString());
        adapterSpinnerActivity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPassingActivity.setAdapter(adapterSpinnerActivity);
    }

    ///////////////////////////////////////////////////////////////
    //
    // Spinner onItemSelected and onNothingSelected Using
    //
    ///////////////////////////////////////////////////////////////

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        sharedData.setMyCurrentActivity(this);

        sharedData.setSpinnerNavigation(position, parent.getId());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
