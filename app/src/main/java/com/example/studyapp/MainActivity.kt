package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var KotlinReview: Button
    lateinit var AndroidReview:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KotlinReview=findViewById(R.id.KotlinReview)
        AndroidReview=findViewById(R.id.AndroidReview)

        KotlinReview.setOnClickListener{
            var intent= Intent(this,KotlinReview_Activity::class.java)
            startActivity(intent)
        }
        AndroidReview.setOnClickListener{
            var intent= Intent(this,AndroidReview_Activity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.KotlinReview -> {
                var intent= Intent(this,KotlinReview_Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.AndroidReview -> {
                var intent= Intent(this,AndroidReview_Activity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}