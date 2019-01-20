package com.example.loeric.testlottie

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class NextPage: AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nextpage)
        val loadingBtn  = findViewById<LottieAnimationView>(R.id.loadingBtn)

        loadingBtn.setOnClickListener {
            loadingBtn.setMinAndMaxFrame(29, 305)

            loadingBtn.speed = 2f

            loadingBtn.playAnimation()

            loadingBtn.addAnimatorUpdateListener {
                if (it.animatedFraction == 1f){  //動畫完成後

                    val i = Intent(this@NextPage, Third::class.java)
                    startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

                }

            }

        }

    }
}