package com.example.google.playservices.placepicker;

import android.os.Bundle;
import android.app.Activity;

public class ReviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
