package com.test.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////////////////////////////////////////
    //
    // Text widget
    //
    ///////////////////////////////////////////////////////////////

    TextView idTxt;
    EditText editTxtWriting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////////////////////////////////////////////////////
        //
        // Edit Text
        //
        ///////////////////////////////////////////////////////////////

        editTxtWriting = (EditText) findViewById(R.id.editTxtWriting);

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

        idTxt = (TextView) findViewById(R.id.idTxt);

        idTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myVar = idTxt.getText().toString();

                Toast.makeText(getApplicationContext(), myVar, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
