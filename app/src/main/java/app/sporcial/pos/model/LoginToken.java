package app.sporcial.pos.model;

import com.google.gson.annotations.SerializedName;

public class LoginToken
{
    @SerializedName("token")
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
