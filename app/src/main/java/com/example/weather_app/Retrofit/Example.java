package com.example.weather_app.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Example {
    @SerializedName("main")
    private Main main;


   public Main getMain() {
       return main;
   }

   public void setMain(Main main) {
        this.main = main;
    }

  @SerializedName("weather")
    private ArrayList<Weather>  weather;

   public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }
}
