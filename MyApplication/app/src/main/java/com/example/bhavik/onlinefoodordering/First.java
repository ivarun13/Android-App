package com.example.bhavik.onlinefoodordering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by Bhavik on 6/2/16.
 */
public class First extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
    }

    public void onSignupHereClick (View view)
    {
        if (view.getId() == R.id.Bsuhere)
        {
            Intent i = new Intent(view.getContext(),SignUp.class);
            startActivity(i);
        }
    }

    public void onLoginFirstClick (View view)
    {
        if (view.getId() == R.id.BloginFirst)
        {
            Intent i = new Intent(view.getContext(),MainActivity.class);
            startActivity(i);
        }
    }

//    public void onButtonClick (View v)
//    {
//        if (v.getId() == R.id.Bsuhere)
//        {
//            Intent i = new Intent(v.getContext(),SignUp.class);
//            startActivity(i);
//        }
//
//        if (v.getId() == R.id.BloginFirst)
//        {
//            Intent i = new Intent(v.getContext(),MainActivity.class);
//            startActivity(i);
//        }
//
//    }
}
