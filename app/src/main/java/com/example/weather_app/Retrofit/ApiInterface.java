package com.example.weather_app.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather?&appid=0b95f10dae8f6b9d9f3cd2c0777cd4ed&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);
}
