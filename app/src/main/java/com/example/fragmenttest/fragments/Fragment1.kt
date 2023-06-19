package com.example.fragmenttest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmenttest.databinding.Fragment1Binding
import com.example.fragmenttest.homefragments.HomeFragment1
import com.example.fragmenttest.homefragments.HomeFragment2
import com.example.fragmenttest.homefragments.HomeFragment3
import com.example.fragmenttest.utils.NestedScrollableHost
import com.google.android.material.tabs.TabLayoutMediator

class Fragment1 : Fragment() {

    private lateinit var tableLayout:TableLayout
    private lateinit var viewpaper:ViewPager2
    private val tabTitles= mutableListOf<String>("关注","发现","郑州")
    private val fragments= listOf(lazy { HomeFragment1()},lazy {HomeFragment2()},lazy {HomeFragment3()})
    private lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= Fragment1Binding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=viewPaperAdapter()
        binding.viewPaper.requestDisallowInterceptTouchEvent(true)
        binding.viewPaper.adapter=adapter
        TabLayoutMediator(binding.tabHeader,binding.viewPaper){
            tab,position->
            tab.text=tabTitles[position]
        }.attach()
    }
    inner class viewPaperAdapter:FragmentStateAdapter(this){
        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position].value as Fragment
        }

    }

}