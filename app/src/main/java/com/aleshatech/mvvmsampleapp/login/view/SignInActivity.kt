package com.aleshatech.mvvmsampleapp.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.aleshatech.mvvmsampleapp.MainActivity
import com.aleshatech.mvvmsampleapp.R
import com.aleshatech.mvvmsampleapp.databinding.ActivitySignInBinding
import com.aleshatech.mvvmsampleapp.login.viewmodel.SignInViewModel
import com.aleshatech.mvvmsampleapp.utils.CustomeProgressDialog

class SignInActivity : AppCompatActivity() {
    private lateinit var viewModel: SignInViewModel
    private lateinit var binding: ActivitySignInBinding
    private lateinit var customPDialog : CustomeProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_sign_in)
        binding = ActivitySignInBinding.inflate(layoutInflater) //view binding
        setContentView(binding.root) //attach root view with activity

        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java) //initialize viewModel
        customPDialog = CustomeProgressDialog(this)

        binding.signInBtn.setOnClickListener(){
            var userName = binding.signInEmailInput.editText!!.text.toString()
            var password = binding.signInPasswordInput.editText!!.text.toString()
            viewModel.validateUserName(userName)
            if(!viewModel.validateUserName(userName)){
                binding.signInEmailInput.error = "Field can not be empty"
                return@setOnClickListener
            }

            if(!viewModel.validateUserPassword(password)){
                binding.signInPasswordInput.error = "Field can not be empty"
                return@setOnClickListener
            }


            viewModel.login(userName,password)

        }

        setLiveDataListeners()

    }


    private fun setLiveDataListeners() {
        viewModel.liveDataSucc.observe(this, {
            Log.i("checkData", "setLiveDataListeners: ${it}")

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        })

        viewModel.liveDataFail.observe(this, {
            Log.i("checkData", "setLiveDataListeners: $it")
        })


        viewModel.progressBarLiveData.observe(this, {
            Log.i("checkData", "setLiveDataListeners: ${it}")

            if(it){
                customPDialog.show()
            }else{
                customPDialog.dismiss()
            }

        })

    }

}