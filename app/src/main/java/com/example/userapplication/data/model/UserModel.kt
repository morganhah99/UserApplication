package com.example.userapplication.data.model


import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("per_page")
    val perPage: Int? = 0,
    @SerializedName("support")
    val support: SupportModel? = SupportModel(),
    @SerializedName("total")
    val total: Int? = 0,
    @SerializedName("total_pages")
    val totalPages: Int? = 0
)