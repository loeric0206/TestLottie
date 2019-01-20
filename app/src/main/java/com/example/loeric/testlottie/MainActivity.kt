package com.example.loeric.testlottie

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    @SuppressLint("Range")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val upLeftView: LottieAnimationView = findViewById(R.id.up_left_view)
        val upRightView = findViewById<LottieAnimationView>(R.id.up_right_view)
        val bottomLeftView = findViewById<LottieAnimationView>(R.id.bottom_left_view)
        val lottieAnimationView3 = findViewById<LottieAnimationView>(R.id.view4)
        val nextBtn = findViewById<Button>(R.id.nextBtn)

//        val testBtn: Button = findViewById(R.id.testBtn)


        var flag = 0
        var count = 0
        var start = 0

        val playPauseBtn: LottieAnimationView = findViewById(R.id.play_pause)
        playPauseBtn.speed = 2f
        playPauseBtn.setAnimation("play_to_pause.json")
//        playPauseBtn.setMinFrame(0)


        playPauseBtn.setOnClickListener {
            if (start == 0) {
                playPauseBtn.setAnimation("play_to_pause.json")
                start += 1
            }

            playPauseBtn.playAnimation()

            if (playPauseBtn.isAnimating) {
                playPauseBtn.setOnClickListener {

                    if (count % 2 == 0) {
                        playPauseBtn.setAnimation("pause_to_play.json")
                        playPauseBtn.playAnimation()
                        upLeftView.pauseAnimation()
                        upRightView.pauseAnimation()
                        count += 1

                    } else {
                        playPauseBtn.setAnimation("play_to_pause.json")
                        playPauseBtn.playAnimation()
                        upLeftView.resumeAnimation()
                        upRightView.resumeAnimation()
                        count += 1

                    }

                }

            }

            upRightView.playAnimation()
            if (upRightView.isAnimating) {

                upLeftView.playAnimation()

                upRightView.addAnimatorUpdateListener {
                    if (it.animatedFraction == 1f) {
                        playPauseBtn.setAnimation("pause_to_play.json")
                        playPauseBtn.playAnimation()

                        upLeftView.pauseAnimation()
                        upLeftView.setMinFrame(0)

                    }

                }

            }

        }

        bottomLeftView.setOnClickListener {
            bottomLeftView.playAnimation()
        }

        lottieAnimationView3.setOnClickListener {
            when (flag % 2) {

                1 -> lottieAnimationView3.setMinAndMaxFrame(133, 154)

                0 -> lottieAnimationView3.setMinAndMaxFrame(60, 72)

            }

            flag += 1

            lottieAnimationView3.playAnimation()

        }

        nextBtn.setOnClickListener {
            val i = Intent(this@MainActivity, NextPage::class.java)
            startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }


//        testBtn.setOnClickListener {
//
//            lottieAnimationView.playAnimation()
//            if (lottieAnimationView.isAnimating){
//
//                view1.playAnimation()
//
//
//            }
//
//        }

//        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.view)
//        lottieAnimationView.setAnimation("win_result_2.json")
//        lottieAnimationView.loop(true)

    }


}
