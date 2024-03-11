package com.example.sns_project

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.sns_project.databinding.Signup1Binding
import com.example.sns_project.databinding.Signup2Binding
import java.util.regex.Pattern

class Signup_2: Fragment() {
    private lateinit var binding: Signup2Binding
    private lateinit var callback: OnBackPressedCallback
    private lateinit var signupMain: Signup_main
    val api = RetroInterface.create()
    val pwPattern =
        "^(?=.*[a-zA-Z0-9])(?=.*[a-zA-Z!@#\$%^&*])(?=.*[0-9!@#\$%^&*]).{6,15}\$"
    val pattern = Pattern.compile(pwPattern)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Signup2Binding.inflate(layoutInflater)

        val main = activity as Signup_main
        var name = main.name1




        binding.signup2Btn.setOnClickListener{
            val pwlength = binding.signup2Pw.length()
            val matcher = pattern.matcher(binding.signup2Pw.text.toString())
            if (pwlength == 0){
                Log.e("pw","빈칸")
                binding.signup2Pw.setBackgroundResource(R.drawable.warningtextbox)
                binding.signup2PwErr.text = "비밀번호가 빈칸입니다."
                binding.signup2PwErr.visibility = View.VISIBLE
            }else if(matcher.find() == true){
                Log.e("pw","사용가능")
            }else {
                binding.signup2Pw.setBackgroundResource(R.drawable.warningtextbox)
                binding.signup2PwErr.text = "영어,특수 기호,숫자 중 2가지를 포함 하여야 합니다."
                binding.signup2PwErr.visibility = View.VISIBLE
            }
        }


        return binding.root
    }
}