package com.example.register_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.register_fragment.databinding.ActivityLogRegBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.Math.abs


class LogRegActivity : AppCompatActivity() {

    companion object{
        var username = ""
        var password = ""
        lateinit var viewPager2 : ViewPager2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLogRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            viewPager.adapter = TabAdapter(this@LogRegActivity)
            viewPager2 = viewPager

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = when (position) {
                    0 -> "Register"
                    1 -> "Login"
                    else -> ""
                }
            }.attach()
        }

    }






}

