package com.geektech.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.geektech.weatherapp.data.weather.WeatherDataSource;
import com.geektech.weatherapp.data.weather.model.ForecastEntity;
import com.geektech.weatherapp.data.weather.model.WeatherResponse;
import com.geektech.weatherapp.data.weather.remote.WeatherRemoteDataSource;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new WeatherRemoteDataSource()
                .getWeather(new WeatherDataSource.WeatherCallback() {
            @Override
            public void onSuccess(WeatherResponse result) {
                Log.d("ololo", "Success " + result.getCode() +
                        " " + result.getCount() + " " + result.getCity().getName());

                for (ForecastEntity forecast : result.getForecast()) {
                    Log.d("ololo", "Forecast temp " + forecast.getMainData().getTemperature());
                }
            }

            @Override
            public void onFailure() {
                Log.d("ololo", "Failure");
            }
        });
    }
}
