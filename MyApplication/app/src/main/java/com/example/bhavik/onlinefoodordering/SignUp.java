package com.example.bhavik.onlinefoodordering;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Bhavik on 5/26/16.
 */
public class SignUp extends Activity
{

    DataBaseHelper helper = new DataBaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignupClick(View v)
    {
        if (v.getId() == R.id.Bsignupbutton)
        {
            EditText name = (EditText)findViewById(R.id.TFname);
            EditText email = (EditText)findViewById(R.id.TFemailaddress);
            EditText pass = (EditText)findViewById(R.id.TFSpass);
            EditText confpass = (EditText)findViewById(R.id.TFconpass);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String passstr = pass.getText().toString();
            String confpassstr = confpass.getText().toString();

            if (!passstr.equals(confpassstr))
            {
                //popup message
                Toast password = Toast.makeText(SignUp.this , "Password doesn't match" , Toast.LENGTH_SHORT);
                password.show();
            }
            else
            {
                //insert data into database
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setPassword(passstr);

                helper.insertContact(c);
            }
        }
    }
}
