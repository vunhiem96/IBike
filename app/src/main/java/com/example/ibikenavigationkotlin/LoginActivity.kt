package com.example.ibikenavigationkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ibikenavigationkotlin.model.DataAcount
import com.example.ibikenavigationkotlin.utils.AppConfig
import com.example.viewpagerkotlin.utils.ibikeService
import com.google.gson.Gson
import kotlinx.android.synthetic.main.login_layout.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class LoginActivity : AppCompatActivity() {
    internal lateinit var data : ArrayList<DataAcount>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        rl_login_button.setOnClickListener {
            getData()
        }

    }

//fun getData1(){
//    val soDienThoai = edt_phone_number.getText().toString()
//
//    // lay du lieu
//    val getLogin = GetLogin("0387490078", "hjgjhg", "android")
//    val retrofit = Retrofit.Builder()
//        .addConverterFactory(GsonConverterFactory.create())
//        .baseUrl("http://45.118.144.19:1904/api/")
//        .build()
//    retrofit.create<ibikeService>(ibikeService::class.java!!).getAccout(getLogin).enqueue(object : Callback<ResponseBody> {
//        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//            try {
//                val strJson = response.body()!!.string()
//                val gson = Gson()
//                val login = gson.fromJson<Any>(strJson, DataAcount::class.java)
//                val phone = login.r
//
//                if (soDienThoai == phone) {
//                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
//                    val ten = login.getLoginResult().getCustomerName().toString()
//                    Appconfig.setPhoneNumber(ten, this@MainActivity)
//                    startActivity(intent)
//                    finish()
//                } else {
//                    Toast.makeText(this@MainActivity, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show()
//                }
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//
//        }
//
//        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//            Toast.makeText(this@MainActivity, "fail", Toast.LENGTH_SHORT).show()
//
//        }
//    })
//
//}
//});
//
//}

    private fun getData() {
        val getLogin = GetLogin("0387490078","hjgjhg", "android")
        val retrofit = Retrofit.Builder()
            .baseUrl("http://45.118.144.19:1904/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create<ibikeService>(ibikeService::class.java!!).getAccout(getLogin).enqueue(object :
            Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                var apiJson: String? = null
                try {

                    apiJson = response.body()!!.string()
                    val gson = Gson()
                    var dataphone = gson.fromJson(apiJson, DataAcount::class.java)

                    var sdt= dataphone.result?.phone.toString()

                    var x = dataphone.result?.customerName.toString()

                       AppConfig.setPhoneNumber(x, this@LoginActivity)


                    val soDienThoai = edt_phone_number.getText().toString()

                    if(sdt == soDienThoai){
                     intent = Intent(this@LoginActivity, MainActivity::class.java)
                     startActivity(intent)
                 }else{
                     Toast.makeText(this@LoginActivity, "Số điện thoại chưa được đăng kí", Toast.LENGTH_SHORT).show()
                 }

                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Vui lòng kiểm tra lại 3G/Wifi", Toast.LENGTH_SHORT).show()
            }
        })

    }

    internal inner class GetLogin(var PhoneNumber: String, var DeviceID: String, var Os: String)
}
