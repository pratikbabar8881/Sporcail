package app.sporcial.pos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import app.sporcial.pos.R;

public class LaunchingActivity extends AppCompatActivity {

    private Button login, signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launching_activity);


        login = findViewById(R.id.bt_launch_login);
        signup = findViewById(R.id.bt_launch_signup);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in =new Intent(LaunchingActivity.this,LoginActivity.class);
                startActivity(in);
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in =new Intent(LaunchingActivity.this,SignUpActivity.class);
                startActivity(in);
            }
        });

    }

}