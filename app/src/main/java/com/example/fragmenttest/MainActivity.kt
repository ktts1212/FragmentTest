package com.example.fragmenttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.fragmenttest.adapters.DialogAdapter
import com.example.fragmenttest.databinding.ActivityMainBinding
import com.example.fragmenttest.entity.Dialog

class MainActivity : ComponentActivity() {
    private val dialogList=ArrayList<Dialog>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initList()
        val layoutManager=LinearLayoutManager(this)
        val gridLayoutManager=GridLayoutManager(this,2)
        val staggeredGridLayoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager=staggeredGridLayoutManager
        val adapter=DialogAdapter(dialogList)
        binding.recyclerView.adapter=adapter

    }

    fun initList(){
        for (i in 1..20){
            if (i%2==0){
                val dialog=Dialog("家人们，谁懂啊！！",R.drawable.img)
                dialogList.add(dialog)
            }else{
                val dialog=Dialog("我是一只小小小喵，想要吃鱼干却怎么也吃不到！",R.drawable.ic_cat)
                dialogList.add(dialog)
            }
        }
    }
}