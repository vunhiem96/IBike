package com.example.ibikenavigationkotlin.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ibikenavigationkotlin.MainActivity

import com.example.ibikenavigationkotlin.R
import com.example.ibikenavigationkotlin.adapter.AllAdapter
import com.example.ibikenavigationkotlin.model.DataAcount
import com.example.ibikenavigationkotlin.model.DataAll
import com.example.ibikenavigationkotlin.model.ResultAll
import com.example.viewpagerkotlin.utils.ibikeService
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_all.*
import kotlinx.android.synthetic.main.login_layout.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AllFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all, container, false)

}
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getData()
    }
    private fun getData() {
        val getAll = GetAll("28B1-0009","", 2)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://45.118.144.19:1904/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create<ibikeService>(ibikeService::class.java!!).getAll(getAll).enqueue(object :
            Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                var apiJson: String? = null
                try {

                    apiJson = response.body()!!.string()
                    val gson = Gson()
                    var dataAll = gson.fromJson(apiJson, DataAll::class.java)
                    rv_all.layoutManager = LinearLayoutManager(context)
                    var data = dataAll.result as ArrayList<ResultAll>
                    rv_all.adapter = context?.let { AllAdapter(it, data ) }



                    } catch (e: IOException) {
                    e.printStackTrace()
                }

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(activity, "Vui lòng kiểm tra lại 3G/Wifi", Toast.LENGTH_SHORT).show()
            }
        })

    }
    internal inner class GetAll(var BikeID: String, var SearchKey: String, var Page: Int)

}
