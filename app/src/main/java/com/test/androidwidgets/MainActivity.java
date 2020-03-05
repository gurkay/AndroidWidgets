package com.test.androidwidgets;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////////////////////////////////////////
    //
    // Widget Components
    //
    ///////////////////////////////////////////////////////////////

    TextView idTxt;
    EditText editTxtWriting;
    Button  btnMessage;
    ToggleButton toggleButton;
    Switch switchDemo;
    LinearLayout mainLinearLayout;
    ImageButton imageButton;
    Context context = this;

    ///////////////////////////////////////////////////////////////
    //
    // Variables
    //
    ///////////////////////////////////////////////////////////////

    String editTxtWritingValue, stringTestValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////////////////////////////////////////////////////
        //
        // Image Button Component Using
        //
        ///////////////////////////////////////////////////////////////

        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Image Button Clicked", Toast.LENGTH_SHORT).show();

                ///////////////////////////////////////////////////////////////
                //
                // Send Second Activity Values
                //
                ///////////////////////////////////////////////////////////////

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                editTxtWritingValue = editTxtWriting.getText().toString();
                stringTestValue = "String Test Value";
                intent.putExtra("editTxtWritingValue", editTxtWritingValue);
                intent.putExtra("stringTestValue", stringTestValue);
                startActivity(intent);
                finish();
            }
        });

        ///////////////////////////////////////////////////////////////
        //
        // Switch Component Using
        //
        ///////////////////////////////////////////////////////////////

        switchDemo = findViewById(R.id.switchDemo);
        mainLinearLayout = findViewById(R.id.mainLinearLayout);

        switchDemo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchDemo.isChecked()){
                    mainLinearLayout.setBackgroundColor(Color.YELLOW);
                    Toast.makeText(getApplicationContext(), "Switch State : " + switchDemo.getTextOn().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    mainLinearLayout.setBackgroundColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Switch State : " + switchDemo.getTextOff().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        ///////////////////////////////////////////////////////////////
        //
        // Edit Text
        //
        ///////////////////////////////////////////////////////////////

        editTxtWriting = findViewById(R.id.editTxtWriting);

        editTxtWriting.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = editTxtWriting.getText().toString();
                idTxt.setText(str);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ///////////////////////////////////////////////////////////////
        //
        // Text widget
        //
        ///////////////////////////////////////////////////////////////

        idTxt = findViewById(R.id.idTxt);

        idTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myVar = idTxt.getText().toString();

                Toast.makeText(getApplicationContext(), myVar, Toast.LENGTH_SHORT).show();

            }
        });

        ///////////////////////////////////////////////////////////////
        //
        // Button widget
        //
        ///////////////////////////////////////////////////////////////

        btnMessage = findViewById(R.id.btnMessage);

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastTop = Toast.makeText(getApplicationContext(), "Position Top", Toast.LENGTH_SHORT);
                toastTop.setGravity(Gravity.TOP, 0, 0);
                toastTop.show();

                Toast toastCenter = Toast.makeText(getApplicationContext(), "Position Center", Toast.LENGTH_SHORT);
                toastCenter.setGravity(Gravity.CENTER, 0, 0);
                toastCenter.show();

                Toast toastBotton = Toast.makeText(getApplicationContext(), "Position Bottom", Toast.LENGTH_SHORT);
                toastBotton.setGravity(Gravity.BOTTOM, 0, 0);
                toastBotton.show();
            }
        });

        ///////////////////////////////////////////////////////////////
        //
        // Toggle Button widget
        //
        ///////////////////////////////////////////////////////////////

        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()){
                    Toast.makeText(getApplicationContext(), "Toggle Button : " + toggleButton.getText().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Toggle Button : " + toggleButton.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
