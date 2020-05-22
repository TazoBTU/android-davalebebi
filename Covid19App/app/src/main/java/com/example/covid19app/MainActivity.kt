package com.example.covid19app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        signInUpBtn.setOnClickListener {
            singInUpHandler(it)
        }

        if (auth.currentUser != null) {
            proceedToApp()
        }

    }

    private fun singInUpHandler(view: View) {
        auth.signInWithEmailAndPassword(enterEmail.text.toString(), enterPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    proceedToApp()
                } else {
                    auth.createUserWithEmailAndPassword(enterEmail.text.toString(),
                        enterPassword.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                proceedToApp()
                            } else {
                                Toast.makeText(this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }

    }

    private fun proceedToApp() {
        val intent = Intent(this, SummaryActivity::class.java)
        startActivity(intent)
    }


}
