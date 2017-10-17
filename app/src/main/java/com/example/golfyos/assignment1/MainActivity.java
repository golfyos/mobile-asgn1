package com.example.golfyos.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        EditText name = (EditText) findViewById(R.id.name);
        EditText lastname = (EditText) findViewById(R.id.lastname);
        EditText age = (EditText) findViewById(R.id.age);
        EditText email = (EditText) findViewById(R.id.email);
        EditText phoneNo = (EditText) findViewById(R.id.phoneNo);

        String nameText = name.getText().toString();
        String lastnameText = lastname.getText().toString();
        String ageText = age.getText().toString();
        String emailText = email.getText().toString();
        String phoneText = phoneNo.getText().toString();


        if (validateEmail(emailText) ) {
            if(validatePhoneNo(phoneText)) {
                intent.putExtra("name", nameText);
                intent.putExtra("lastname", lastnameText);
                intent.putExtra("age", ageText);
                intent.putExtra("email", emailText);
                intent.putExtra("phoneNo", phoneText);
                startActivity(intent);
            }
            else{
                phoneNo.setError("phone number is not valid");
                phoneNo.requestFocus();
            }
        } else {
            email.setError("Email is not valid");
            email.requestFocus();
        }



    }

    public boolean validateEmail(String email) {
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

    public boolean validatePhoneNo(String number){
        return number.length()==10;
    }

}
