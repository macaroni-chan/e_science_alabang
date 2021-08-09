package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btn_search;
    Button btn_country_list;
    EditText et_key_word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_search = findViewById(R.id.btn_search);
        btn_country_list = findViewById(R.id.btn_clist);
        et_key_word = findViewById(R.id.edit_text_search);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item_search = et_key_word.getText().toString();
                if(item_search.isEmpty()){
                    alert();
                }else{
                    Intent nav = new Intent(getApplicationContext(), country_search_deets.class);
                    nav.putExtra("key", item_search);
                    startActivity(nav);
                    finish();
                }
            }
        });

        btn_country_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nav = new Intent(getApplicationContext(), country_holder.class);
                startActivity(nav);
                finish();
            }
        });
    }

    private void alert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Search bar is empty.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //no events
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }
}