package com.example.myrecipeappoficial;

import android.content.Context;
import android.content.Intent;
import android.media.TimedText;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private static List<MealModelClass>meal_data;
    public ItemClickListener itemClickListener;


    public Adapter(Context context, List<MealModelClass> meal_data, ItemClickListener itemClickListener ) {
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.meal_data = meal_data;
        this.itemClickListener = itemClickListener;
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
//        holder.category.setText(meal_data.get(position).getMealCategory());
        Glide.with(context).load(meal_data.get(position).getMealImage()).into(holder.image);

        holder.itemView.setOnClickListener(view ->{
            itemClickListener.onItemClick(meal_data.get(position));
        });


    }


    @Override
    public int getItemCount() {
        return meal_data.size();
    }

    public interface ItemClickListener{
        void onItemClick(MealModelClass meal_data);
    }

    public class MyViewHolder  extends  RecyclerView.ViewHolder{

        TextView name;
        ImageView image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.meal_name_txt);
//            category = itemView.findViewById(R.id.meal_category_txt);
            image = itemView.findViewById(R.id.meal_image);



        }
    }
}
