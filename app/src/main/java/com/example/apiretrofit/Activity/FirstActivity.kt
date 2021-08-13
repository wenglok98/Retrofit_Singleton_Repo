package com.example.apiretrofit.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.apiretrofit.R
import com.example.apiretrofit.Repository.UserRepository
import com.example.apiretrofit.databinding.ActivityFirstBinding
import com.example.apiretrofit.databinding.ActivityMainBinding
import com.example.apiretrofit.models.UserCredential

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var obj1 = UserCredential()
        obj1.username = "00001"
        obj1.password = "Password123!@#"

        UserRepository.SetUserCredential(obj1)

        UserRepository.getUserLiveData().observe(this, Observer {
            binding.contactNumberTv.text = it.user?.contact_number
            binding.genderTv.text = it.user?.gender
            binding.lastNameTv.text = it.user?.last_name
            binding.statusTv.text = it.user?.status
        })

        binding.nextBt.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.Change.setOnClickListener {
            UserRepository.changeData("First Page Data")
        }


    }
}