package com.example.propertywatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Creates a listFragment var, to pass in conditions using arguments
        var listFragment = listFragment()



        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        //setups the initial fragment
        fragmentTransaction.replace(R.id.fragmentContainer, listFragment)
        fragmentTransaction.commit()
    }
}