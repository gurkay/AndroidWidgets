package com.test.androidwidgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class SecondActivity extends AppCompatActivity {

    ///////////////////////////////////////////////////////////////
    //
    // Widget Components
    //
    ///////////////////////////////////////////////////////////////

    TextView txtViewSecondActivity;
    Button backMainActivity;

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
    }
}
