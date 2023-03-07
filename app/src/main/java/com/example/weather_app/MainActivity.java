package com.example.weather_app;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather_app.Retrofit.ApiClient;
import com.example.weather_app.Retrofit.ApiInterface;
import com.example.weather_app.Retrofit.Example;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView temptextView,destextView,textView,inttext;
    ListView listView1;
    ImageView img;
    ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList("Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya", "Ardahan", "Artvin", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir", "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"));
    String city,a;
    Button button;

    public void init() {
        temptextView=(TextView) findViewById(R.id.temptextView);
        destextView=(TextView) findViewById(R.id.destextView);
        textView=(TextView) findViewById(R.id.textView);
        img=(ImageView) findViewById(R.id.imageView);
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=(ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,arrayList);
        listView1.setAdapter(adapter);

        init();
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(getApplicationContext(),arrayList.get(i), Toast.LENGTH_LONG).show();
            city= arrayList.get(i);
            getWeatherData(city);
            Log.d("__DATA", "onItemClick:  im clicked : " + city);
        }

        });
    }
    private void getWeatherData(String name){
        Log.d("__DA", "getWeatherData: started ");
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<Example> call=apiInterface.getWeatherData(name);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.d("__DA", "getWeatherData: on response started ");


                Log.d("__DATA", response.body().getMain().getTemp());
                    temptextView.setText(response.body().getMain().getTemp()+" C");
                    Log.d("__WData", response.body().getMain().getFeels_like());
                    destextView.setText("Feels Like "+response.body().getMain().getFeels_like());
                   Log.d("__WData", response.body().getMain().getFeels_like());
                    textView.setText(response.body().getWeather().get(0).getDescription());
                    String a=response.body().getWeather().get(0).getDescription();
                    switch (a){
                        case "few clouds":
                            img.setImageResource(R.drawable.parcali);
                            break;
                        case  "broken clouds":
                            img.setImageResource(R.drawable.parcali);
                            break;
                        case "scattered clouds":
                            img.setImageResource(R.drawable.parcali);
                            break;
                        case "overcast cloud":
                            img.setImageResource(R.drawable.parcali);
                            break;
                        case "clear sky":
                            img.setImageResource(R.drawable.gunes);
                            break;
                        case "clouds":
                            img.setImageResource(R.drawable.bulut);
                            break;




                    }


                Log.d("__DA", "getWeatherData: on response ended ");

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }
}



