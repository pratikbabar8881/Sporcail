package app.sporcial.pos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.sporcial.pos.R;
import app.sporcial.pos.remote.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText username, password;
    private String TAG = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        Button login = findViewById(R.id.bt_submit);
        Button signin = findViewById(R.id.bt_login_signin);

        // LoginDTO loginDTO =  new LoginDTO(username.getText().toString(),password.getText().toString());

        login.setOnClickListener(v -> {

            String user_validation = username.getText().toString();
            String user_password = password.getText().toString();
            if (!isValidUser(user_validation)) username.setError("Invalid Username");

            else if (!isValidPassword(user_password)) password.setError("Invalid Password");

            else if (!user_validation.equals("") && !user_password.equals("")) {
                Call<ResponseBody> call = RetrofitClient.getInstance().getApi()
                        .createUser(username.getText().toString(), password.getText()
                                .toString());

                //Call<ResponseBody> call = RetrofitClient.getInstance().getApi().createUser(loginDTO);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call,
                                           Response<ResponseBody> response) {
                        Toast.makeText(LoginActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();
                        Log.d(TAG, "onResponse: " + response.body().toString());

                        startActivity(new Intent(LoginActivity.this, FirstPageActivity.class));
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
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

        signin.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        });
    }

    private boolean isValidUser(String username) {

/*
        String email_pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
*/
        return username.equals("") && username.length() < 150;
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() > 6;
    }
}
