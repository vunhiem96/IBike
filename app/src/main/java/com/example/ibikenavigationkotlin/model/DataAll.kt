package com.example.ibikenavigationkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataAll {

    @SerializedName("status")
    @Expose
    var status: Int? = null
    @SerializedName("code")
    @Expose
    var code: Int? = null
    @SerializedName("result")
    @Expose
    var result: List<ResultAll>? = null
    @SerializedName("message")
    @Expose
    var message: String? = null

}