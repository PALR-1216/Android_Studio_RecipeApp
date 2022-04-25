package com.example.myrecipeappoficial;

// Search query == https://www.themealdb.com/api/json/v1/1/search.php?s=p

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String JSON_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=p";
    ProgressDialog progressDialog;

    List<MealModelClass>meal_data;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meal_data = new ArrayList<>();
        recyclerView = findViewById(R.id.mealRecyclerView);



        GetData getData = new GetData();
        getData.execute();


    }




    public class GetData extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {


            //string current will hould all our json
            String current = "";


            try {
                URL url;
                HttpURLConnection httpURLConnection= null;

                try {

                    //try and get data from url
                    url = new URL(JSON_URL);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream is = httpURLConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();

                    while (data != -1) {
                        current += (char) data;
                        data = isr.read();
                    }

                    return  current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {

                    //close connection
                    if(httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject  jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("meals");
                for(int i =0 ; i < jsonArray.length(); i++) {
                    JSONObject mealJsonData = jsonArray.getJSONObject(i);

                    MealModelClass model = new MealModelClass();

                    model.setMealName(mealJsonData.getString("strMeal"));
                    model.setMealCategory(mealJsonData.getString("strCategory"));
                    model.setMealImage(mealJsonData.getString("strMealThumb"));
                    model.setYoutubeLink(mealJsonData.getString("strYoutube"));
                    model.setInstructions(mealJsonData.getString("strInstructions"));


                    meal_data.add(model);


                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(meal_data);
        }
    }


    private void PutDataIntoRecyclerView(List<MealModelClass>meal_data) {

        Adapter adapter = new Adapter(this, meal_data, new Adapter.ItemClickListener() {
            @Override
            public void onItemClick(MealModelClass meal_data) {

               Intent intent = new Intent(MainActivity.this, SelectedActivity.class);
                intent.putExtra("MealName", meal_data.getMealName());
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    private void ShowToast(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

}