package com.test.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////////////////////////////////////////
    //
    // Text widget Component
    //
    ///////////////////////////////////////////////////////////////

    TextView idTxt;
    EditText editTxtWriting;
    Button  btnMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
