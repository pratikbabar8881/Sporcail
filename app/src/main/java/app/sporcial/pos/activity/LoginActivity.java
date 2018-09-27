package app.sporcial.pos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.sporcial.pos.R;
import app.sporcial.pos.model.LoginDTO;
import app.sporcial.pos.model.LoginToken;
import app.sporcial.pos.remote.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private String TAG = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        Button login = findViewById(R.id.bt_submit);
        //Button signup = findViewById(R.id.bt_login_signin);

        // LoginDTO loginDTO =  new LoginDTO(username.getText().toString(),password.getText().toString());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_email = email.getText().toString();
                String user_password = password.getText().toString();

                if (!isValidEmail(user_email))
                    email.setError("Invalid Email");

                else if (!isValidPassword(user_password))
                    password.setError("Invalid Password");

                else if (!user_email.equals("") && !user_password.equals("")) {

                    LoginDTO loginDTO=new LoginDTO(email.getText().toString(),password.getText().toString());

                    Call<LoginToken> call = RetrofitClient.getInstance().getApi()
                            .createLogin(loginDTO);

                    //Call<ResponseBody> call = RetrofitClient.getInstance().getApi().createUser(loginDTO);
                    call.enqueue(new Callback<LoginToken>() {
                        @Override
                        public void onResponse(Call<LoginToken> call,
                                               Response<LoginToken> response)
                        {
                            if(response.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, response.body().getToken(), Toast.LENGTH_LONG).show();
                                Log.d(TAG, "onResponse: " + response.body().getToken());
                                startActivity(new Intent(LoginActivity.this, FirstPageActivity.class));
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this,"Invalid ",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginToken> call, Throwable t) {
                            Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                            Log.d(TAG, "onFailure: "+t.getMessage());
                        }
                    });
                }
            }
        });

        /*login.setOnClickListener(new View.OnClickListener() {
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
*/

        /*signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });*/
    }

    private boolean isValidEmail(String username) {

        String email_pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
        //return username.equals("") && username.length() < 150;
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() > 6;
    }
}
