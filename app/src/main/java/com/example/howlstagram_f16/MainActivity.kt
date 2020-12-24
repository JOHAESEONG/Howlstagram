package com.example.howlstagram_f16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.example.howlstagram_f16.databinding.ActivityLoginBinding
import com.example.howlstagram_f16.databinding.ActivityMainBinding
import com.example.howlstagram_f16.navigation.AlarmFragment
import com.example.howlstagram_f16.navigation.DetailViewFragment
import com.example.howlstagram_f16.navigation.GridFragment
import com.example.howlstagram_f16.navigation.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.rpc.context.AttributeContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.action_home ->{
                    val detailViewFragment = DetailViewFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.main_content, detailViewFragment).commit()
                    true
                }
                R.id.action_search ->{
                    val gridFragment = GridFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.main_content,gridFragment).commit()
                    true
                }
                R.id.action_add_photo ->{
                    true
                }
                R.id.action_favorite_alarm->{
                    val alarmFragment = AlarmFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.main_content, alarmFragment).commit()
                    true
                }
                R.id.action_account -> {
                    val userFragment = UserFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.main_content, userFragment).commit()
                    true
                }
                else -> false
            }
        }
    }
}