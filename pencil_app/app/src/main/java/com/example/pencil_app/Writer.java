package com.example.pencil_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Writer extends Pencil{

    String text = "";
    String f_text = "";
    String pen_type;
    String color;
    String[] entries = {"", "", "", "", ""};
    int index = 0;
    Context context;

    public Writer(Context context){
        this.context = context;
    }

    public void write_in_graph(String pen_type, int index, String text){
        this.pen_type = pen_type;
        this.index = index;
        this.text = text;

        check_char_count();
    }

    public void write_in_color(String pen_type, int index, String text, String color){
        this.pen_type = pen_type;
        this.index = index;
        this.color = color;
        this.text = text;

        check_char_count();
    }

    private void write(){
        if(index >= 5 || index < 0){
            Toast.makeText(context, "Index is out of bounds.", Toast.LENGTH_SHORT).show();
        }else{
            entries[index] = text;
        }
    }

    private void check_char_count(){

        String f = text.replaceAll("\\s+", "");

        if(pen_type.equals("Graphite pencil")){
            if(f.length() > super.get_graphite_chars()){
                Toast.makeText(context, "Characters are greater than 50", Toast.LENGTH_SHORT).show();
            }else{
                write();
            }
        }else if(pen_type.equals("Colored pencil")){
            if(f.length() > super.get_colored_chars()){
                Toast.makeText(context, "Characters are greater than 30", Toast.LENGTH_SHORT).show();
            }else{
                write();
            }
        }
    }

    private void check_char_count(int index, String text){

        String f = text.replaceAll("\\s+", "");

        if(pen_type.equals("Graphite pencil")){
            Log.d("test", "graph");
            Log.d("test", String.valueOf(f.length()));
            if(f.length() > super.get_graphite_chars()){
                Toast.makeText(context, "Characters are greater than 50", Toast.LENGTH_SHORT).show();
            }else{
                entries[index] = text;
            }
        }else if(pen_type.equals("Colored pencil")){
            Log.d("test", "col");
            if(f.length() > super.get_colored_chars()){
                Toast.makeText(context, "Characters are greater than 30", Toast.LENGTH_SHORT).show();
            }else{
                write();
            }
        }
    }

    public void edit(int index, String text){
        check_char_count(index, text);
    }

    public void delete(int index){
        entries[index] = "";
    }

    public void read_entries(){
        int counter = 0;
        for(String text : entries){
            f_text += "Entry " + counter + ": " + text + "\n";
            counter += 1;
        }
        alert();
    }

    private void alert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(f_text)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        f_text = "";
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
