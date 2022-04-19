package com.example.myrecipeappoficial;

public class MealModelClass {
    String mealName;
    String mealCategory;
    String MealImage;
    String description;

    public MealModelClass(String mealName, String mealCategory, String mealImage) {
        this.mealName = mealName;
        this.mealCategory = mealCategory;
        MealImage = mealImage;
    }

    public MealModelClass() {
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(String mealCategory) {
        this.mealCategory = mealCategory;
    }

    public String getMealImage() {
        return MealImage;
    }

    public void setMealImage(String mealImage) {
        MealImage = mealImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
