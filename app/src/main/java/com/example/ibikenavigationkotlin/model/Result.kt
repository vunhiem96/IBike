package com.example.ibikenavigationkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @SerializedName("customerName")
    @Expose
    var customerName: String? = null
    @SerializedName("taxCode")
    @Expose
    var taxCode: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("listBike")
    @Expose
    var listBike: List<String>? = null

}