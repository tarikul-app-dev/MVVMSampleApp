package com.aleshatech.mvvmsampleapp.login.model

import com.aleshatech.mvvmsampleapp.login.model.datamodel.LoginModel
import com.example.mvpinkotlin.network.ApiClient
import com.example.mvpinkotlin.network.ApiInterface
import com.example.mvpinkotlin.network.RequestCompleteListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInModel  {
    companion object {
        private val apiInterface: ApiInterface = ApiClient().getClient.create(ApiInterface::class.java)

        fun login(userName:String,password:String,callback: RequestCompleteListener<LoginModel>) {
            val call: Call< LoginModel> = apiInterface.login(userName,password)
            call.enqueue(object : Callback< LoginModel> {
                override fun onResponse(
                    call: Call< LoginModel>,
                    response: Response< LoginModel>
                ) {
                    if (response.code() == 200) {
                        response.body()?.let { callback.onSuccess(it) }
                    } else {
                        callback.onFailed(response.message())
                    }
                }

                override fun onFailure(call: Call< LoginModel>, t: Throwable) {
                    callback.onFailed(t.message.toString())
                }

            })
        }
    }
}