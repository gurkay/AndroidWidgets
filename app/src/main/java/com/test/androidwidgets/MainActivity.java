package com.test.androidwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////////////////////////////////////////
    //
    // Text widget
    //
    ///////////////////////////////////////////////////////////////

    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            }
        });
    }
}
