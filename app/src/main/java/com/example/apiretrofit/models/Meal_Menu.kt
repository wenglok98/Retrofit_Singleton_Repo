package com.example.apiretrofit.models

import com.google.gson.annotations.SerializedName
import java.util.*

class Meal_Menu(


    @SerializedName("id")
    val id: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("outlet")
    val outlet: String? = null,
    @SerializedName("meal_type")
    val meal_type: String? = null,
    @SerializedName("meal_name")
    val meal_name: String? = null,
    @SerializedName("meal_set")
    val meal_set: String? = null,
    @SerializedName("meal_cat")
    val meal_cat: String? = null,
    @SerializedName("price")
    val price: Integer? = null,
    @SerializedName("for_date")
    val for_date: String? = null,
    @SerializedName("is_halal")
    val is_halal: Boolean? = null,
    @SerializedName("sold_out")
    val sold_out: Boolean? = null,
    @SerializedName("photo")
    val photo: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("vending_type")
    val vending_type: String? = null,
    @SerializedName("allergens")
    val allergens: ArrayList<String>? = null


    ) {
}