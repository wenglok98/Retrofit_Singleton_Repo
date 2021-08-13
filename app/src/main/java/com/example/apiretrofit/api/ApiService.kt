package com.example.apiretrofit.api

import com.example.apiretrofit.models.DataWrapper
import com.example.apiretrofit.models.Meal_Menu
import com.example.apiretrofit.models.UserCredential
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface ApiService {

    @POST("custom/auth/mobile")
    suspend fun getLogin(@Body credential: UserCredential): DataWrapper

    @GET("assets/{avatarId}")
    suspend fun getAvatar(
        @Header("Authorization") Authorization: String,
        @Path("avatarId") avatarID: String
    ): ResponseBody

    @GET("custom/meal/menu")
    suspend fun getMealMenu(
        @Query("start") start_date: String,
        @Query("end ") end_date: String,
        @Header("Authorization") Authorization: String,

    ): Response<ArrayList<Meal_Menu>>



}