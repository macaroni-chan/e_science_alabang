package com.example.test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface Requests {

    @GET("alpha/{search_key}")
    Call<country_data_model> get_country_info(@Path(value = "search_key", encoded = true)
                                                      String search_key);

    @GET("all?fields=name;flag;")
    Call<country_data_model> get_clist_flags();
}
