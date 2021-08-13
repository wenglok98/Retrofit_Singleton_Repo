package com.example.apiretrofit.models

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.apiretrofit.api.MyRetrofitBuilder
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class User(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("first_name")
    val first_name: String? = null,
    @SerializedName("last_name")
    val last_name: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("avatar")
    val avatar: String? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("last_access")
    val last_access: String? = null,
    @SerializedName("date_created")
    val date_created: String? = null,
    @SerializedName("date_updated")
    val date_updated: String? = null,
    @SerializedName("user_type")
    val user_type: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("can_id")
    val can_id: String? = null,
    @SerializedName("meal_cap")
    val meal_cap: String? = null,

    @SerializedName("allergen")
    val allergen: ArrayList<String>? = null,

    @SerializedName("is_halal")
    val is_halal: Boolean? = null,

    @SerializedName("credit")
    val credit: Credit? = null,

    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("contact_number")
    val contact_number: String? = null,
    @SerializedName("from_school")
    val from_school: String? = null,
    @SerializedName("from_school_other")
    val from_school_other: String? = null,
    @SerializedName("cluster")
    val cluster: String? = null,
    @SerializedName("level")
    val level: String? = null,
    @SerializedName("level_other")
    val level_other: String? = null,
    @SerializedName("bed_num")
    val bed_num: String? = null,
    @SerializedName("class")
    val class_name: String? = null,


    ) {

    lateinit var get_Avatar: Bitmap

    fun setAvatar(token: String) {
        CoroutineScope(IO).launch{
            val avatar = avatar?.let { MyRetrofitBuilder.apiService.getAvatar(token, it) }
            val inputStream = avatar?.byteStream()
            val bitmap = BitmapFactory.decodeStream(inputStream)
            get_Avatar = bitmap
        }


    }

    fun returnAvatar(token: String): Bitmap {
        lateinit var tempBit: Bitmap
        runBlocking {
            val avatar = avatar?.let { MyRetrofitBuilder.apiService.getAvatar(token, it) }
            val inputStream = avatar?.byteStream()
            tempBit = BitmapFactory.decodeStream(inputStream)
        }
        return tempBit
    }
}