package com.example.viewpagerkotlin.utils

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ibikeService {


    @POST("Service/Login")
    fun getAccout(@Body `object`: Any): Call<ResponseBody>

    @POST("Service/GetPriceListMaterial")
    fun getAll(@Body `object`: Any): Call<ResponseBody>



}
