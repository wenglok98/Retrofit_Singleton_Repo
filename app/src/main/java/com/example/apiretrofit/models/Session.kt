package com.example.apiretrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Session(
    @SerializedName("access_token")
    val access_token: String? = null,

    @SerializedName("refresh_token")
    val refresh_token: String? = null,

    @SerializedName("expires")
    val expires: String? = null,

    @SerializedName("id")
    val id: String? = null,

    ) {


}