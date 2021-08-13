package com.example.apiretrofit.models

import com.google.gson.annotations.SerializedName


class Credit(

    @SerializedName("balance")
    val balance: Integer? = null,
    @SerializedName("currency")
    val currency: String? = null,


    ) {
}