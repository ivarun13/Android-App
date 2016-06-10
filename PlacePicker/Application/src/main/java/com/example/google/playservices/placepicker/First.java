package com.example.google.playservices.placepicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by varun on 6/9/16.
 */
public class First extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
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
            Intent i = new Intent(view.getContext(),Login.class);
            startActivity(i);
        }
    }

}
