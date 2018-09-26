package app.sporcial.pos.activity;

import app.sporcial.pos.model.LoginDTO;
import app.sporcial.pos.model.SignInDTO;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService
{

    @FormUrlEncoded
    @POST("login/")
    Call<ResponseBody> createUser(
            @Field("username") String email_login,
            @Field("password") String password_login);


/*
 @POST("login/")
    Call<ResponseBody> createUser(@Body LoginDTO loginDTO);

*/
 @POST("signup/")
    Call<ResponseBody> createSignUp(@Body SignInDTO signInDTO);

}
