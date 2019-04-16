package edu.missouriwestern.csc445.integration

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_splash_sequential)
        splash_logo.startAnimation(logoAnimation)
        val titleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_splash_alpha)
        app_name.startAnimation(titleAnimation)

        val viewPager = Intent(this, PlanetsActivity::class.java)

        val splashTimer = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(4000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(viewPager)
                    finish()
                }
                super.run()
            }
        }

        splashTimer.start()
    }
}
