package app.sporcial.pos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.sporcial.pos.R;

public class SignUpActivity extends AppCompatActivity {

    EditText email, password, confirm_password, mobile;
    Button signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        confirm_password = findViewById(R.id.et_conpassword);
        mobile = findViewById(R.id.et_mobile);

        signup = findViewById(R.id.bt_login_signin);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String get_email = email.getText().toString();
                final String get_password = password.getText().toString();
                final String get_mobile = mobile.getText().toString();
                final String get_conpassword = confirm_password.getText().toString();

                if (!isValidEmail(get_email)) {
                    email.setError("Invalid Email");

                }
                else if (!isValidPassword(get_password)) {
                    password.setError("invalid password");
                }

                else if (!get_conpassword.equals(get_password)) {
                    confirm_password.setError("Invalid Password");
                }

                else if (!isvalidMobile(get_mobile)) {
                    mobile.setError("Invalid Mobile");
                }

                else if (!get_email.equals("") && !get_password.equals("") &&
                        !get_conpassword.equals("") && !get_mobile.equals("")) {
                    Intent in = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(in);
                }

            }
        });


    }


    private boolean isValidEmail(String email) {

        String email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private boolean isValidPassword(String password) {
        if (password != null && password.length() > 6) {
            return true;
        }
        return false;
    }

    private boolean isvalidMobile(String mobile) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", mobile)) {
            if (mobile.length() < 6 || mobile.length() > 13) {
                check = false;

            } else {
                check = true;

            }
        } else {
            check = false;
        }
        return check;


    }
}
