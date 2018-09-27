package app.sporcial.pos.remote;

import app.sporcial.pos.model.LoginDTO;
import app.sporcial.pos.model.LoginToken;
import app.sporcial.pos.model.SignInDTO;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService
{


    @POST("vendor/login/")
    Call<LoginToken> createLogin(@Body LoginDTO loginDTO);


/*
 @POST("login/")
    Call<ResponseBody> createUser(@Body LoginDTO loginDTO);

*/
 @POST("vendor/signup/")
    Call<ResponseBody> createSignUp(@Body SignInDTO signInDTO);

}
