package com.aleshatech.mvvmsampleapp.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.aleshatech.mvvmsampleapp.R


class CustomeProgressDialog(context: Context?) : Dialog(context!!) {
    private var imgvLogo :ImageView ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_progress)
        imgvLogo = findViewById<ImageView>(R.id.iv_logo)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        val rotate = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotate.duration = 1000
        rotate.repeatCount = Animation.INFINITE
        imgvLogo!!.startAnimation(rotate)
    }

}