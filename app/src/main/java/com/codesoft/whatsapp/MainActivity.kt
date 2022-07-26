package com.codesoft.whatsapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.codesoft.whatsapp.activity.NumberActivity
import com.codesoft.whatsapp.adapter.ViewPagerAdapter
import com.codesoft.whatsapp.databinding.ActivityMainBinding
import com.codesoft.whatsapp.ui.CallFragment
import com.codesoft.whatsapp.ui.ChatFragment
import com.codesoft.whatsapp.ui.StatusFragment
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(ChatFragment())
        fragmentArrayList.add(StatusFragment())
        fragmentArrayList.add(CallFragment())

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser == null){
            startActivity(Intent(this, NumberActivity::class.java))
            finish()
        }

        val adapter = ViewPagerAdapter(this,supportFragmentManager,fragmentArrayList)

        binding!!.viewPager.adapter = adapter

        binding!!.tabs.setupWithViewPager(binding!!.viewPager)

    }
}