package com.example.apiretrofit.models


import com.google.gson.annotations.SerializedName


class DataWrapper(
    @SerializedName("session")
    val session: Session? = null,
    @SerializedName("user")
    val user: User? = null,

    ) {


}