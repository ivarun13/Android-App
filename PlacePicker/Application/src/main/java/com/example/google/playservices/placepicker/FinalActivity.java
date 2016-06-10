package com.example.google.playservices.placepicker;

import android.os.Bundle;
import android.app.Activity;

public class FinalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
