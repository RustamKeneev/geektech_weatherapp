package com.geektech.weatherapp.data.weather;

import com.geektech.weatherapp.data.weather.model.WeatherResponse;

/**
 * Created by askar on 1/29/19
 * with Android Studio
 */
public interface WeatherDataSource {

    void getWeather(WeatherCallback callback);

    interface WeatherCallback {
        void onSuccess(WeatherResponse result);

        void onFailure();
    }

}
