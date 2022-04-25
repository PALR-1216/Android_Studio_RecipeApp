package com.example.myrecipeappoficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class SelectedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView mealName = (TextView) findViewById(R.id.mealName);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

       String myMealName = getIntent().getStringExtra("MealName");



       Toast.makeText(this,myMealName,Toast.LENGTH_SHORT).show();

    }
}