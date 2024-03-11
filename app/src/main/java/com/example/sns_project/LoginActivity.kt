package com.example.sns_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sns_project.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {


    lateinit var binding : ActivityLoginBinding
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()


        binding.loginBtn.setOnClickListener{
            LoginButton()

        }

    }

    fun LoginButton(){
        if (binding.loginID.text.toString() =="" && binding.loginPw.text.toString()==""){
            binding.loginID.setBackgroundResource(R.drawable.edittextbox)
            binding.loginPw.setBackgroundResource(R.drawable.edittextbox)
            binding.loginID.setBackgroundResource(R.drawable.warningtextbox)
            binding.loginPw.setBackgroundResource(R.drawable.warningtextbox)
            binding.loginwarning.visibility = View.VISIBLE
        }else if (binding.loginID.text.toString() ==""){
            binding.loginID.setBackgroundResource(R.drawable.edittextbox)
            binding.loginPw.setBackgroundResource(R.drawable.edittextbox)
            binding.loginID.setBackgroundResource(R.drawable.warningtextbox)
            binding.loginwarning.text = "아이디가 빈칸입니다."
            binding.loginwarning.visibility = View.VISIBLE
        }else if (binding.loginPw.text.toString()==""){
            binding.loginID.setBackgroundResource(R.drawable.edittextbox)
            binding.loginPw.setBackgroundResource(R.drawable.edittextbox)
            binding.loginPw.setBackgroundResource(R.drawable.warningtextbox)
            binding.loginwarning.text = "비밀번호가 빈칸입니다."
            binding.loginwarning.visibility = View.VISIBLE
        }else{
            auth!!.signInWithEmailAndPassword(binding.loginID.text.toString(),binding.loginPw.text.toString())
                .addOnCompleteListener(this) { task->
                    if (task.isSuccessful){
                        binding.loginID.setBackgroundResource(R.drawable.edittextbox)
                        binding.loginPw.setBackgroundResource(R.drawable.edittextbox)
                        Log.e("login","ok")
                    }else{
                        binding.loginID.setBackgroundResource(R.drawable.edittextbox)
                        binding.loginPw.setBackgroundResource(R.drawable.edittextbox)
                        binding.loginwarning.text = "아이디/비밀번호를 다시 확인하여 주십시오."
                        binding.loginwarning.visibility = View.VISIBLE
                        Log.e("login","fail")
                    }
                }
            }
        }



}