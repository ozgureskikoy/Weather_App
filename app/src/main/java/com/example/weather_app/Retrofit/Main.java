package com.example.weather_app.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Main {


   private String temp;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }


    private String feels_like;

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }
}
