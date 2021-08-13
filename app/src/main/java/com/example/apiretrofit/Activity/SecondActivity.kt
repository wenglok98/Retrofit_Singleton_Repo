package com.example.apiretrofit.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.apiretrofit.R
import com.example.apiretrofit.Repository.UserRepository
import com.example.apiretrofit.databinding.ActivityFirstBinding
import com.example.apiretrofit.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        UserRepository.getUserLiveData().observe(this, Observer {
            binding.contactNumberTv.text = it.user?.contact_number
            binding.genderTv.text = it.user?.gender
            binding.lastNameTv.text = it.user?.last_name
            binding.statusTv.text = it.user?.status
        })



        binding.nextBt.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.Change.setOnClickListener {
            UserRepository.changeData("Second Page Data")
        }
    }
}