package com.example.firebasedeneme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebasedeneme.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=Firebase.auth

        // giriş yapılan kullanıcıyı hatırlamak için
        val guncelkullanici= auth.currentUser
        if (guncelkullanici !=null) {
            val intent =Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()

        }


    }
    fun kayitol(view: View){
        val email= binding.emailText.text.toString()
        val sifre= binding.sifreText.text.toString()
        println(email)

        // kullanıcıyı oluşturucaz
        auth.createUserWithEmailAndPassword(email,sifre).addOnCompleteListener (this){task ->
            if (task.isSuccessful){
                val intent =Intent(this,MainActivity2::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext,"başarıyla giriş yaptınız",Toast.LENGTH_LONG).show()
            }

        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }

    }


    fun girisyap(view: View){
        val email= binding.emailText.text.toString()
        val sifre=binding.sifreText.text.toString()
        auth.signInWithEmailAndPassword(email,sifre).addOnCompleteListener { task ->

            if(task.isSuccessful){
                val guncelkullanici =auth.currentUser?.email.toString()
                Toast.makeText(applicationContext,"hoşgeldiniz",Toast.LENGTH_LONG).show()
                val  intent =Intent(this,MainActivity2::class.java)
                startActivity(intent)

            }

        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }


    }
}