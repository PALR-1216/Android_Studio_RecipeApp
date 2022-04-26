package com.example.myrecipeappoficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class SelectedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        String myMealName = getIntent().getStringExtra("MealName");
        String selectedMealImage = getIntent().getStringExtra("mealImage");
        String selectedInstructions = getIntent().getStringExtra("instructions");
        TextView mealName = (TextView) findViewById(R.id.selectedMealName);
        TextView instructions = (TextView) findViewById(R.id.selectedInstructions);
        ImageView mealImage = (ImageView) findViewById(R.id.selectedMealImage);
        Button youtubeLinkButton = (Button) findViewById(R.id.youtubeLinkButton);


        mealName.setText(myMealName);
        instructions.setMovementMethod(new ScrollingMovementMethod());
        instructions.setText(selectedInstructions);


        youtubeLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


       //Toast.makeText(this,myMealName,Toast.LENGTH_SHORT).show();

    }
}