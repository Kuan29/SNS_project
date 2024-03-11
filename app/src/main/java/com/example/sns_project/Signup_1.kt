package com.example.sns_project

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.sns_project.databinding.ActivityHomeBinding
import com.example.sns_project.databinding.Signup1Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signup_1 :Fragment(){
    private lateinit var binding: Signup1Binding
    private lateinit var callback: OnBackPressedCallback

    val api = RetroInterface.create()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Signup1Binding.inflate(layoutInflater)
        binding.signup1Btn.setOnClickListener{
            binding.apply {
                val name = signup1Name.text.toString()

                if (name == ""){
                    binding.signup1Name.setBackgroundResource(R.drawable.warningtextbox)
                    binding.signup1NameErr.text = "이름이 빈칸입니다."
                    binding.signup1NameErr.visibility = View.VISIBLE
                }
            }
            val UserName= SignupNameModel(binding.signup1Name.text.toString())
            api.name_veri(UserName).enqueue(object : Callback<SignupNameResult> {
                override fun onResponse(call: Call<SignupNameResult>, response: Response<SignupNameResult>) {
                    val message = response.body()?.message?: return
                    if (message == true){
                        Log.e("test", "사용가능")
                        val main = activity as Signup_main
                        main.receiveName(binding.signup1Name.text.toString())
                        main.setFragment(Signup_2())
                    }else if(message == false){
                        binding.signup1Name.setBackgroundResource(R.drawable.warningtextbox)
                        binding.signup1NameErr.text = "이미사용중인 이름입니다."
                        binding.signup1NameErr.visibility = View.VISIBLE
                    }

                }

                override fun onFailure(call: Call<SignupNameResult>, t: Throwable) {
                }

            })
        }
        return binding.root

    }
}