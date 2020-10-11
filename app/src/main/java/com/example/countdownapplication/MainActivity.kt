package com.example.countdownapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.countdownapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private lateinit var binding:ActivityMainBinding
   // private lateinit var btmNavView: BottomNavigationView
    //private  lateinit var  justFab: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
      //  setContentView(R.layout.activity_main)
    btm_nav_view.background = null
      btm_nav_view.menu.getItem(1).isEnabled = false
        binding.justFab.setOnClickListener {
            val intent = Intent(this@MainActivity, FirstActivity::class.java)
            startActivity(intent)
        }


    }
}
