package com.example.ibikenavigationkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultAll {

    @SerializedName("materialID")
    @Expose
    var materialID: String? = null
    @SerializedName("materialName")
    @Expose
    var materialName: String? = null
    @SerializedName("unit")
    @Expose
    var unit: String? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null
    @SerializedName("maxKm")
    @Expose
    var maxKm: Int? = null

}