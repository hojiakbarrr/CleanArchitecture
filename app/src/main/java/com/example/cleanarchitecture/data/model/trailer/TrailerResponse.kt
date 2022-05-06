package com.example.cleanarchitecture.data.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailerResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val trailerList: List<DataTrailer>,
)
