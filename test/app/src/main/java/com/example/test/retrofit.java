package com.example.test;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {

    private static Retrofit retrofit_instance;
    private static String base = "https://restcountries.eu/rest/v2/";

    public static Retrofit get_instance(){
        retrofit_instance = new Retrofit.Builder().baseUrl(base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit_instance;
    }
}
