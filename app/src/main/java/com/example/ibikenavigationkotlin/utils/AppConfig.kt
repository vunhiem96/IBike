package com.example.ibikenavigationkotlin.utils

import android.content.Context

object AppConfig {
    val PREF_NAME = "Android005"
    fun setPhoneNumber(phoneNumber: String, context: Context) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("phone_number", phoneNumber)
        editor.apply()
    }

    fun getPhoneNumber(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString("phone_number", null)
    }
}