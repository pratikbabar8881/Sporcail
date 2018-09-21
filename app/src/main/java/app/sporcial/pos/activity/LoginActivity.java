package app.sporcial.pos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.sporcial.pos.R;

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    Button login,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.et_username);
        password=findViewById(R.id.et_password);
        login=findViewById(R.id.bt_submit);
        signin=findViewById(R.id.bt_login_signin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email_validation=email.getText().toString();
                String password_validation=password.getText().toString();

                if(!isValidEmail(email_validation))
                {
                    email.setError("Invalid Email");

                }

                else if(!isValidPassword(password_validation))
                {
                    password.setError("Invalid Password");

                }

                else if(!email_validation.equals("") && !password_validation.equals(""))
                {
                    Intent in=new Intent(LoginActivity.this,FirstPageActivity.class);
                    startActivity(in);
                }

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

    private boolean isValidEmail(String email)
    {

        String email_pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private boolean isValidPassword(String password)
    {
        if(password!=null && password.length()>6)
        {
            return  true;
        }
        return false;
    }
}
