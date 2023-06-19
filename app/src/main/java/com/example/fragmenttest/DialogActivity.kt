package com.example.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.fragmenttest.databinding.ActivityDialogBinding
import com.example.fragmenttest.fragments.Fragment1
import com.example.fragmenttest.fragments.Fragment2
import com.example.fragmenttest.fragments.Fragment3
import com.example.fragmenttest.fragments.Fragment4
import com.example.fragmenttest.fragments.Fragment5
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class DialogActivity : AppCompatActivity() {
    private val fragment1 by lazy {
        Fragment1()
    }
    private val fragment2 by lazy {
        Fragment2()
    }
    private val fragment3 by lazy {
        Fragment3()
    }
    private val fragment4 by lazy {
        Fragment4()
    }
    private val fragment5 by lazy {
        Fragment5()
    }
    private lateinit var binding: ActivityDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val position=intent.getIntExtra("position",-1)
//        val title=intent.getStringExtra("title")
     //   binding.dialogTitle.text="我的位置是${position},我的标题是${title}"
        val fragmentManager=supportFragmentManager
        val transcation=fragmentManager.beginTransaction()
        transcation.replace(R.id.fragment_container,fragment1)
        transcation.commit()

        binding.bottmoNavigationView.setOnItemSelectedListener {
            val transcation=fragmentManager.beginTransaction()
            when(it.itemId){
                R.id.home->{
                    transcation.replace(R.id.fragment_container,fragment1)
                    transcation.commit()
                    return@setOnItemSelectedListener true
                }
                R.id.shop->{
                    transcation.replace(R.id.fragment_container,fragment2)
                    transcation.commit()
                    return@setOnItemSelectedListener true
                }
                R.id.publish->{
                    transcation.replace(R.id.fragment_container,fragment3)
                    transcation.commit()
                    return@setOnItemSelectedListener true
                }
                R.id.message->{
                    transcation.replace(R.id.fragment_container,fragment4)
                    transcation.commit()
                    return@setOnItemSelectedListener true
                }
                R.id.my->{
                    transcation.replace(R.id.fragment_container,fragment5)
                    transcation.commit()
                    return@setOnItemSelectedListener true
                }
                else->false
            }
        }
    }
}