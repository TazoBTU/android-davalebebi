package com.example.starwars

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity (){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val background = object : Thread() {
            override fun run(){
                try{
                    Thread.sleep(4000)
                    val intent=Intent(baseContext,MainActivity::class.java)
                    startActivity((intent))
                } catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}