package com.example.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class country_holder extends AppCompatActivity {

    private List<country_data_model> countries_and_flags_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_holder);

        Requests requests = retrofit.get_instance().create(Requests.class);
        Call<country_data_model> call = requests.get_clist_flags();

        call.enqueue(new Callback<country_data_model>() {
            @Override
            public void onResponse(Call<country_data_model> call, Response<country_data_model> response) {
                Toast.makeText(country_holder.this, "HTTP status" + response.code(),
                        Toast.LENGTH_SHORT).show();

                if(response.body() != null){
                    //do things
                }else{
                    alert();
                }
            }

            @Override
            public void onFailure(Call<country_data_model> call, Throwable t) {
                Log.d("response: ", String.valueOf(t.getCause()));
            }
        });
    }

    private void alert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Failed to get data.")
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
