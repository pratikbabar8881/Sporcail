package com.sporcial.pos.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import app.sporcial.pos.R;


public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button login,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);

        username=findViewById(R.id.et_username);
        password=findViewById(R.id.et_password);
        login=findViewById(R.id.bt_submit);
        signin=findViewById(R.id.bt_login_signin);

        final String get_name=username.getText().toString();
        final String get_password=password.getText().toString();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(get_name.equals("") || get_password.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Invalid ", Toast.LENGTH_SHORT).show();
                }
                Intent in=new Intent(getApplicationContext(),FirstPageActivity.class);
                startActivity(in);

                Toast.makeText(LoginActivity.this,"",Toast.LENGTH_LONG).show();
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(in);


            }
        });

    }
}
