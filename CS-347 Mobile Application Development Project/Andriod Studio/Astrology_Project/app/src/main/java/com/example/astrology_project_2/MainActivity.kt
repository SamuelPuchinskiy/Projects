 package com.example.astrology_project_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)


    }

     override fun onSupportNavigateUp(): Boolean {
         val navController = findNavController(R.id.fragment)
         return navController.navigateUp()
     }

}
