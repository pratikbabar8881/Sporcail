package app.sporcial.pos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.sporcial.pos.R;

import static android.text.Html.fromHtml;

public class LaunchingActivity extends AppCompatActivity {

    private Button login, signup;
    private TextView signup_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launching_activity);


        login = findViewById(R.id.bt_launch_login);
//        signup = findViewById(R.id.bt_l);
        signup_text = findViewById(R.id.tv_text);

        signup_text.setText(fromHtml("<font color='#ffffff'>No account yet?</font><font color='#adc22d'>create one</font>"));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in =new Intent(LaunchingActivity.this,LoginActivity.class);
                startActivity(in);
            }
        });


        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in =new Intent(LaunchingActivity.this,SignUpActivity.class);
                startActivity(in);
            }
        });

    }

}