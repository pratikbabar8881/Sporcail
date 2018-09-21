package com.sporcial.pos.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.sporcial.pos.R;

public class SignUpActivity extends AppCompatActivity
{
    EditText email,password,mobile;
    Button signup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        mobile=findViewById(R.id.et_mobile);

        signup=findViewById(R.id.bt_login_signin);


        final String get_email=email.getText().toString();
        final String get_password=password.getText().toString();
        final String get_mobile=mobile.getText().toString();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(get_email.equals("") || get_password.equals("") || get_mobile.equals(""))
                {
                    Toast.makeText(SignUpActivity.this, "Invalid Fields", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
