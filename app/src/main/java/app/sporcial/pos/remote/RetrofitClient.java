package app.sporcial.pos.remote;


import app.sporcial.pos.activity.APIService;
import app.sporcial.pos.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
    private static final String BASE_URL="https://demo-todo-rest.herokuapp.com/";
    private static RetrofitClient retrofitClient;
    public Retrofit retrofit;



    private RetrofitClient()
    {
        retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.DEBUG_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

    }


    public static synchronized RetrofitClient getInstance()
    {
        if(retrofitClient == null)
        {
            retrofitClient = new RetrofitClient();
        }

        return retrofitClient;
    }


    public APIService getApi()
    {
        return retrofit.create(APIService.class);
    }








}
