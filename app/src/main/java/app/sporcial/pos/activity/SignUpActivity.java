package app.sporcial.pos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.sporcial.pos.R;
import app.sporcial.pos.model.SignInDTO;
import app.sporcial.pos.remote.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "signup" ;
    EditText email, password, confirm_password, mobile, username;
    Button signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        confirm_password = findViewById(R.id.et_conpassword);
        mobile = findViewById(R.id.et_mobile);
        username = findViewById(R.id.et_username);

        signup = findViewById(R.id.bt_login_signin);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String get_email = email.getText().toString();
                final String get_password = password.getText().toString();
                final String get_mobile = mobile.getText().toString();
                final String get_conpassword = confirm_password.getText().toString();
                final String get_username = username.getText().toString();

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
                else if(!isValidUser(get_username))
                {
                    username.setError("Invalid Username");
                }

                else if (!get_email.equals("") && !get_password.equals("") &&
                        !get_conpassword.equals("") && !get_mobile.equals("")) {

                    //SignInDTO signInDTO=new SignInDTO(email.getText().toString(),password.getText().toString(),mobile.getText().toString(),username.getText().toString());
                    SignInDTO signInDTO = new SignInDTO();
                    signInDTO.setEmail(email.getText().toString());
                    signInDTO.setPassword(password.getText().toString());
                    signInDTO.setPhone_no(mobile.getText().toString());
                    signInDTO.setUsername(username.getText().toString());

                    Call<ResponseBody> call = RetrofitClient.getInstance().getApi().createSignUp(signInDTO);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                            Toast.makeText(SignUpActivity.this,response.message(),Toast.LENGTH_LONG).show();
                           // Log.d(TAG, "onResponse: "+response.body().toString());


                            Intent in = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(in);
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                            Toast.makeText(SignUpActivity.this,t.getMessage().toString(),Toast.LENGTH_LONG).show();

                        }
                    });




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

    private boolean isValidUser(String username)
    {
        if(username!=null && username.length()<150)
        {
            return true;
        }
        return false;
    }


}
