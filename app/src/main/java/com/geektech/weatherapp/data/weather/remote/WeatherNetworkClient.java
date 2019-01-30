package com.geektech.weatherapp.data.weather.remote;

import com.geektech.weatherapp.data.weather.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by askar on 1/29/19
 * with Android Studio
 */
public interface WeatherNetworkClient {

    @GET(WeatherRemoteConfig.FORECAST_URL)
    Call<WeatherResponse> getWeather(
            @Query("q") String city,
            @Query("APPID") String apiKey,
            @Query("lang") String language,
            @Query("units") String units
    );

}
