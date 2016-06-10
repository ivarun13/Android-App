package com.example.google.playservices.placepicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by varun on 6/9/16.
 */
public class SignUp extends Activity{

    DataBaseHelper helper = new DataBaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
    }

    public void onSignupClick(View v) {
        if (v.getId() == R.id.Bsignupbutton) {
            EditText name = (EditText) findViewById(R.id.TFname);
            EditText email = (EditText) findViewById(R.id.TFemailaddress);
            EditText pass = (EditText) findViewById(R.id.TFSpass);
            EditText confpass = (EditText) findViewById(R.id.TFconpass);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String passstr = pass.getText().toString();
            String confpassstr = confpass.getText().toString();

            if (!passstr.equals(confpassstr)) {
                confpass.setError("Password doesn't match");

                //popup message
                Toast password = Toast.makeText(SignUp.this, "Password doesn't match", Toast.LENGTH_SHORT);
                password.show();
            } else if (namestr.isEmpty() || namestr.length() < 3) {
                name.setError("at least 3 characters");

            } else if (emailstr.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailstr).matches()) {
                email.setError("enter a valid email address");
            } else if (passstr.isEmpty() || passstr.length() < 4 || passstr.length() > 15) {
                pass.setError("between 4 to 15 alphanumeric characters");
            } else {
                //insert data into database
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setPassword(passstr);

                helper.insertContact(c);

                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        }
    }

    public void onClick(View view) {

        if (view.getId() == R.id.link_login) {
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
        }

    }
}
