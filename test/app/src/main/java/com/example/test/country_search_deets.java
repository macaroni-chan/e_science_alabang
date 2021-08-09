package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class country_search_deets extends AppCompatActivity {

    String item_search;
    TextView country_name;
    TextView capital;
    TextView region;
    TextView calling_codes;
    TextView population;
    TextView currencies;
    TextView long_lat;
    TextView languages;
    TextView borders;
    String border_list;
    Button btn_open_maps;
    String lat;
    String lng;
    String capital_mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_search_deets);

        Intent current_intent = getIntent();
        item_search = current_intent.getStringExtra("key");

        country_name = findViewById(R.id.text_view_name);
        capital = findViewById(R.id.text_view_capital);
        region = findViewById(R.id.text_view_region);
        calling_codes = findViewById(R.id.text_view_calling_codes);
        population = findViewById(R.id.text_view_population);
        currencies = findViewById(R.id.text_view_curencies);
        long_lat = findViewById(R.id.text_view_long_lat);
        languages = findViewById(R.id.text_view_languages);
        borders = findViewById(R.id.text_view_borders);
        btn_open_maps = findViewById(R.id.btn_open_in_maps);

        btn_open_maps.setEnabled(false);
        
        Requests requests = retrofit.get_instance().create(Requests.class);
        Call<country_data_model> call = requests.get_country_info(item_search);

        call.enqueue(new Callback<country_data_model>() {
            @Override
            public void onResponse(Call<country_data_model> call, Response<country_data_model> response) {
                Toast.makeText(country_search_deets.this, "HTTP status: " + response.code(),
                        Toast.LENGTH_SHORT).show();
                if(response.body() != null) {

                    country_data_model cdata = response.body();
                    ArrayList<country_data_model.CurrenciesData> currencies_data = response.body().getCurrencies();
                    ArrayList<country_data_model.LanguagesData> languages_data = response.body().getLanguages();

                    country_name.setText(new StringBuilder().append("NAME AND ABBREVIATION: ").append(cdata.getName())
                            .append(", ").append(cdata.getAlpha2Code()).append(", ")
                            .append(cdata.getAlpha3Code()));
                    capital.setText(new StringBuilder().append("CAPITAL: ").append(cdata.getCapital()));
                    region.setText(new StringBuilder().append("REGION: ").append(cdata.getRegion()));
                    calling_codes.setText(new StringBuilder().append("CALLING CODES: ").append(cdata.getCallingCodes()));
                    population.setText(new StringBuilder().append("POPULATION: ").append(cdata.getPopulation()));
                    long_lat.setText(new StringBuilder().append("LONGITUDE & LATITUDE: ").append(cdata.getLatlng()));

                    lat = cdata.getLat();
                    lng = cdata.getLong();
                    capital_mp = cdata.getCapital();

                    for(country_data_model.CurrenciesData curr_data : currencies_data){
                        currencies.setText(new StringBuilder().append("Code: ").append(curr_data.getCode())
                                .append(", name: ").append(curr_data.getName())
                                .append(", symbol: ").append(curr_data.getSymbol()).toString());
                    }

                    for(country_data_model.LanguagesData lang_data : languages_data){
                        languages.setText(new StringBuilder().append("iso639_1: ").append(lang_data.getIso639_1())
                                .append(", iso639_2: ").append(lang_data.getIso639_2())
                                .append(", name: ").append(lang_data.getName())
                                .append(", native name: ").append(lang_data.getNativeName()));
                    }
                    for(int index = 0; index < cdata.getBorders().length; index++){
                        String[] ref = cdata.getBorders();
                        border_list += ref[index] + ", ";
                    }

                    borders.setText(border_list);
                    btn_open_maps.setEnabled(true);

                }else {
                    alert();
                }

            }

            @Override
            public void onFailure(Call<country_data_model> call, Throwable t) {

            }
        });

        btn_open_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nav = new Intent(getApplicationContext(), MapsActivity.class);
                nav.putExtra("lat", lat);
                nav.putExtra("lng", lng);
                nav.putExtra("capital", capital_mp);
                startActivity(nav);
                finish();
            }
        });
    }

    private void alert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Search is invalid.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent nav = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(nav);
                        finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent nav = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(nav);
        finish();
    }
}