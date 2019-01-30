package com.geektech.weatherapp.data.weather.remote;

/**
 * Created by askar on 1/29/19
 * with Android Studio
 */
class WeatherRemoteConfig {
    static final String API_URL = "https://api.openweathermap.org";
    private static final String API_DATA = "/data";
    private static final String VERSION = "/2.5";
    static final String FORECAST_URL = API_DATA + VERSION + "/forecast";
    //TODO: Get API key
    static final String API_KEY = "";
}
