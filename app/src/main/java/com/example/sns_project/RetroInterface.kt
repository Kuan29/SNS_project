package com.example.sns_project

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetroInterface {

    @POST("/nameveri")
    fun name_veri(
        @Body jsonparams: SignupNameModel
    ) : Call<SignupNameResult>

    companion object{
        private const val BASE_URL = "http://192.168.0.2:3000"

        fun create():RetroInterface{
            val gson: Gson = GsonBuilder().setLenient().create();
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RetroInterface::class.java)
        }
    }
}