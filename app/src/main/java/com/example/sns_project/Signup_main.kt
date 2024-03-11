package com.example.sns_project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sns_project.databinding.ActivityHomeBinding
import com.example.sns_project.databinding.SignupMainBinding
import com.example.sns_project.databinding.SignupMainBinding.inflate

class Signup_main : AppCompatActivity() {
    var name1 : String = ""
    var pw1: String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_main)

        setFragment(Signup_1())
    }

    fun setFragment(frag : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.signup_view, frag)
            .commit()
    }
    fun receiveName(name:String){
        name1 = name
    }
    fun pullName(): String {
        return name1
    }

}