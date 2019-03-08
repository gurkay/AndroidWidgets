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

    TextView txtView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////////////////////////////////////////////////////
        //
        // Edit Text
        //
        ///////////////////////////////////////////////////////////////

        editText = (EditText) findViewById(R.id.editTxtWriting);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = editText.getText().toString();
                txtView.setText(str);
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

        txtView = (TextView) findViewById(R.id.idTxt);

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myVar = txtView.getText().toString();

                Toast.makeText(getApplicationContext(), myVar, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
