package com.aleshatech.mvvmsampleapp.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aleshatech.mvvmsampleapp.login.model.SignInModel
import com.aleshatech.mvvmsampleapp.login.model.datamodel.LoginModel
import com.example.mvpinkotlin.network.RequestCompleteListener

class SignInViewModel : ViewModel(){
    var liveDataSucc = MutableLiveData<LoginModel>()
    var liveDataFail = MutableLiveData<String>()
    var progressBarLiveData = MutableLiveData<Boolean>()

    fun login(userName:String ,password:String){
        progressBarLiveData.postValue(true)
        SignInModel.login(userName,password,

            object : RequestCompleteListener<LoginModel> {
                override fun onSuccess(data: LoginModel) {
                    liveDataSucc.postValue(data)
                    progressBarLiveData.postValue(false)
                }

                override fun onFailed(message: String) {
                    liveDataFail.postValue(message)
                    progressBarLiveData.postValue(false)
                }

            }
            )
    }

    fun validateUserName(userName: String):Boolean{
        return userName.isNotEmpty()
    }
    fun validateUserPassword(password: String):Boolean{
        return password.isNotEmpty()
    }
}