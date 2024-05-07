package com.example.userapplication.data.model


import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("avatar")
    val avatar: String? = "",
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("first_name")
    val firstName: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("last_name")
    val lastName: String? = ""
)