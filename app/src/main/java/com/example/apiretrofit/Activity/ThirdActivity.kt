package com.example.apiretrofit.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.apiretrofit.R
import com.example.apiretrofit.Repository.UserRepository
import com.example.apiretrofit.databinding.ActivityFirstBinding
import com.example.apiretrofit.databinding.ActivitySecondBinding
import com.example.apiretrofit.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        UserRepository.getUserLiveData().observe(this, Observer {
            binding.contactNumberTv.text = it.user?.contact_number
            binding.genderTv.text = it.user?.gender
            binding.lastNameTv.text = it.user?.last_name
            binding.statusTv.text = it.user?.status
        })


        binding.Change.setOnClickListener {
            UserRepository.changeData("Third Page Data")
        }
    }
}