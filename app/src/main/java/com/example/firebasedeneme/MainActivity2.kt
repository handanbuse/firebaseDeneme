package com.example.firebasedeneme

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlin.system.measureNanoTime

class MainActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    //menüyü tanımla
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val  menuInflater= menuInflater
        menuInflater.inflate(R.menu.anamenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId==R.id.cikisyap){
            auth.signOut()
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)
        auth= Firebase.auth
    }
}