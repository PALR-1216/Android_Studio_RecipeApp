package com.example.myrecipeappoficial;

import android.content.Context;
import android.content.Intent;
import android.media.TimedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<MealModelClass>meal_data;


    public Adapter(Context context, List<MealModelClass> meal_data) {
        this.context = context;
        this.meal_data = meal_data;
    }





    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.recipe_items, parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(meal_data.get(position).getMealName());
        holder.category.setText(meal_data.get(position).getMealCategory());
        Glide.with(context).load(meal_data.get(position).getMealImage()).into(holder.image);






    }


    @Override
    public int getItemCount() {
        return meal_data.size();
    }


    public class MyViewHolder  extends  RecyclerView.ViewHolder{

        TextView name;
        TextView category;
        ImageView image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.meal_name_txt);
            category = itemView.findViewById(R.id.meal_category_txt);
            image = itemView.findViewById(R.id.meal_image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, SelectedItems.class);

                }
            });

        }


    }




}
