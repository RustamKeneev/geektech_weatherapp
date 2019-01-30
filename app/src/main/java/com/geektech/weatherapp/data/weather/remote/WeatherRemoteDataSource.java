package com.geektech.weatherapp.data.weather.remote;

import android.util.Log;

import com.geektech.weatherapp.data.weather.WeatherDataSource;
import com.geektech.weatherapp.data.weather.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by askar on 1/29/19
 * with Android Studio
 */
public class WeatherRemoteDataSource implements WeatherDataSource {
    //TODO: Move to core
    private static Retrofit getRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private WeatherNetworkClient mClient = getRetrofit(WeatherRemoteConfig.API_URL)
            .create(WeatherNetworkClient.class);

    @Override
    public void getWeather(final WeatherCallback callback) {
        //TODO: Receive query via function params
        Call<WeatherResponse> call = mClient.getWeather(
                "Bishkek,kg",
                WeatherRemoteConfig.API_KEY,
                "ru",
                "metric"
        );

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d("ololo", call.request().url().toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    } else {
                        callback.onFailure();
                    }
                } else {
                    callback.onFailure();
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("ololo", "Failure " + t.getMessage());
                callback.onFailure();
            }
        });
    }

}
