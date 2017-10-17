package com.example.golfyos.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nameText = getIntent().getStringExtra("name");
        String lastnameText = getIntent().getStringExtra("lastname");
        String ageText = getIntent().getStringExtra("age");
        String emailText = getIntent().getStringExtra("email");
        String phoneNoText = getIntent().getStringExtra("phoneNo");

        EditText name = (EditText) findViewById(R.id.name);
        EditText lastname = (EditText) findViewById(R.id.lastname);
        EditText age = (EditText) findViewById(R.id.age);
        EditText email = (EditText) findViewById(R.id.email);
        EditText phoneNo = (EditText) findViewById(R.id.phoneNo);

        name.setEnabled(false);
        lastname.setEnabled(false);
        age.setEnabled(false);
        email.setEnabled(false);
        phoneNo.setEnabled(false);


        name.setText(nameText);
        lastname.setText(lastnameText);
        age.setText(ageText + " years");
        email.setText(emailText);
        phoneNo.setText(phoneNoText.substring(0, 3) + "-" + phoneNoText.substring(3, 6) + "-" + phoneNoText.substring(6, 10));

        setImage(Integer.valueOf(ageText));
    }

    public void setImage(int age) {
        ImageView img = (ImageView) findViewById(R.id.img);
        if (age < 16 && age >= 0)
            img.setImageResource(R.drawable.kid);
        else if (age < 26 && age >= 16)
            img.setImageResource(R.drawable.teen);
        else if (age < 61 && age >= 26)
            img.setImageResource(R.drawable.man);
        else
            img.setImageResource(R.drawable.uncle);

    }
}
