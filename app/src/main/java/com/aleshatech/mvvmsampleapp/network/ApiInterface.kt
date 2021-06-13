package com.example.mvpinkotlin.network

import com.aleshatech.mvvmsampleapp.login.model.datamodel.LoginModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiInterface {
    @FormUrlEncoded
    @POST("v3/login")
    fun login(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Call<LoginModel>

}