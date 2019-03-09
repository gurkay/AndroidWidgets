package com.test.androidwidgets;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SecondActivity extends AppCompatActivity {

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

    ///////////////////////////////////////////////////////////////
    //
    // Variables
    //
    ///////////////////////////////////////////////////////////////

    String editTxtWritingValue, stringTestValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ///////////////////////////////////////////////////////////////
        //
        // Main Activity Values and Back Button Component Using
        //
        ///////////////////////////////////////////////////////////////

        editTxtWritingValue = getIntent().getExtras().getString("editTxtWritingValue");
        stringTestValue = getIntent().getExtras().getString("stringTestValue");

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

    }
}
