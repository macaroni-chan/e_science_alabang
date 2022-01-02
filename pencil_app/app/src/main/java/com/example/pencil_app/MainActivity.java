package com.example.pencil_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    String pen_color;
    Writer writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writer = new Writer(MainActivity.this);

        Spinner sp_pen = findViewById(R.id.sp_pencils);
        RadioGroup group_color = findViewById(R.id.radio_group_colors);
        EditText et_text = findViewById(R.id.et_text);
        EditText et_index = findViewById(R.id.et_index);
        Button btn_write = findViewById(R.id.btn_write);
        Button btn_edit = findViewById(R.id.btn_edit);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_show = findViewById(R.id.btn_show);

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pen_type = sp_pen.getSelectedItem().toString();
                String text = et_text.getText().toString();

                if(pen_type.equals("Graphite pencil")){
                    if(text.length() != 0){
                        writer.write_in_graph(pen_type, counter, text);
                        counter += 1;
                    }else{
                        Toast.makeText(MainActivity.this, "Text entry is empty.", Toast.LENGTH_SHORT).show();
                    }
                }else if(pen_type.equals("Colored pencil")){
                    if(group_color.getCheckedRadioButtonId() != -1){
                        pen_color = ((RadioButton)findViewById(group_color.getCheckedRadioButtonId()))
                                .getText().toString();
                    }else{
                        Toast.makeText(MainActivity.this, "Please select a color.", Toast.LENGTH_SHORT).show();
                    }

                    if(text.length() != 0){
                        writer.write_in_color(pen_type, counter, text, pen_color);
                        counter += 1;
                    }else{
                        Toast.makeText(MainActivity.this, "Text entry is empty.", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String index = et_index.getText().toString();
                String text = et_text.getText().toString();

                if(index.length() != 0 && text.length() != 0){
                    writer.edit(Integer.parseInt(index), text);

                }else{
                    Toast.makeText(MainActivity.this, "Please double check the text fields.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String index = et_index.getText().toString();
                if(index.length() != 0){
                    writer.delete(Integer.parseInt(index));
                }
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writer.read_entries();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}