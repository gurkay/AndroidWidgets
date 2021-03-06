package com.test.androidwidgets;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ///////////////////////////////////////////////////////////////
    //
    // Widget Components
    //
    ///////////////////////////////////////////////////////////////

    TextView txtViewSecondActivity;
    Button backMainActivity, btnCheckBoxSubmit;
    CheckBox aCheckBox, bCheckBox;
    RadioButton radioOne, radioTwo, radioThree;
    RadioGroup radioAttendGroup;
    LinearLayout radioLinearLayout;
    Spinner spinnerCity, spinnerPassingActivity;

    ///////////////////////////////////////////////////////////////
    //
    // Variables
    //
    ///////////////////////////////////////////////////////////////

    String editTxtWritingValue, stringTestValue;
    String[] cityName = {"Select City", "ANKARA", "ADANA", "BURSA", "MALATYA", "AFYONKARAHİSAR", "KAHRAMANMARAŞ"};
    SharedData sharedData = new SharedData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ///////////////////////////////////////////////////////////////
        //
        // Main Activity Values and Back Button Component Using
        //
        ///////////////////////////////////////////////////////////////

        if (this.getIntent().getExtras() != null && this.getIntent().getExtras().containsKey("editTxtWritingValue")
        && this.getIntent().getExtras() != null && this.getIntent().getExtras().containsKey("stringTestValue")) {
            editTxtWritingValue = getIntent().getExtras().getString("editTxtWritingValue");
            stringTestValue = getIntent().getExtras().getString("stringTestValue");
        } else if (this.getIntent().getExtras() != null && this.getIntent().getExtras().containsKey("editTxtWritingValue")){
            editTxtWritingValue = getIntent().getExtras().getString("editTxtWritingValue");
        } else if(this.getIntent().getExtras() != null && this.getIntent().getExtras().containsKey("stringTestValue")) {
            stringTestValue = getIntent().getExtras().getString("stringTestValue");
        } else {
            editTxtWritingValue = "null";
            stringTestValue = "null";
        }

        txtViewSecondActivity = findViewById(R.id.txtViewSecondActivity);
        txtViewSecondActivity.setText("value1:" + editTxtWritingValue + " " + "value2:" + stringTestValue);

        backMainActivity = findViewById(R.id.btnBackMainActivity);

        backMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentMainActivity);
                finish();
            }
        });

        ///////////////////////////////////////////////////////////////
        //
        // Check Box Component Using
        //
        ///////////////////////////////////////////////////////////////

        aCheckBox = findViewById(R.id.aCheckBox);
        bCheckBox = findViewById(R.id.bCheckBox);
        btnCheckBoxSubmit = findViewById(R.id.btnCheckBoxSubmit);

        btnCheckBoxSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aCheckBox.isChecked() && bCheckBox.isChecked()){
                    Toast.makeText(SecondActivity.this, "a Checked:" + aCheckBox.getText().toString() + "\n" + "b Checked:" + bCheckBox.getText().toString(), Toast.LENGTH_SHORT).show();
                } else if(aCheckBox.isChecked()) {
                    Toast.makeText(SecondActivity.this, "a Checked:" + aCheckBox.getText().toString(), Toast.LENGTH_SHORT).show();
                } else if(bCheckBox.isChecked()) {
                    Toast.makeText(SecondActivity.this, "b Checked:" + bCheckBox.getText().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecondActivity.this, "Please select any Check Box", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ///////////////////////////////////////////////////////////////
        //
        // Radio Group Button Component Using
        //
        ///////////////////////////////////////////////////////////////

        radioOne = findViewById(R.id.radioOne);
        radioTwo = findViewById(R.id.radioTwo);
        radioThree = findViewById(R.id.radioThree);
        radioAttendGroup = findViewById(R.id.radioAttendGroup);
        radioLinearLayout = findViewById(R.id.radioLinearLayout);

        radioAttendGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioOne:
                        radioLinearLayout.setBackgroundColor(Color.YELLOW);
                        Toast.makeText(SecondActivity.this, "Select: " + radioOne.getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioTwo:
                        radioLinearLayout.setBackgroundColor(Color.BLUE);
                        Toast.makeText(SecondActivity.this, "Select: " + radioTwo.getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioThree:
                        radioLinearLayout.setBackgroundColor(Color.GREEN);
                        Toast.makeText(SecondActivity.this, "Select: " + radioThree.getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        ///////////////////////////////////////////////////////////////
        //
        // Spinner Component Using
        //
        ///////////////////////////////////////////////////////////////

        spinnerCity = findViewById(R.id.spinnerCity);
        spinnerCity.setOnItemSelectedListener(this);
        ArrayAdapter adapterSpinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cityName);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapterSpinner);



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

        if(parent.getId() == R.id.spinnerCity) {
            Toast.makeText(getApplicationContext(), cityName[position], Toast.LENGTH_SHORT).show();
        }

        sharedData.setMyCurrentActivity(this);

        sharedData.setSpinnerNavigation(position, parent.getId());


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
