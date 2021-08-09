package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHoler>{

    private Context context;
    private List<country_data_model> country_data_models;

    public adapter(Context context, List<country_data_model> country_data_model_list) {
        this.context = context;
        this.country_data_models = country_data_model_list;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.country_card, null, false);
        ViewHoler view_holder = new ViewHoler(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        country_data_model cdata = country_data_models.get(position);

        holder.tv_country.setText(cdata.getName());
        Picasso.get().load(cdata.getFlags()).into(holder.img_flag);
    }

    @Override
    public int getItemCount() {
        return country_data_models.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder{

        TextView tv_country;
        ImageView img_flag;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
                tv_country = itemView.findViewById(R.id.text_view_c_name);
                img_flag = itemView.findViewById(R.id.img_flag);
        }
    }
}
