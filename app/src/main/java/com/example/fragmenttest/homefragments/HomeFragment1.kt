package com.example.fragmenttest.homefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TableLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmenttest.R
import com.example.fragmenttest.adapters.DialogAdapter
import com.example.fragmenttest.adapters.StrTitleAdapter
import com.example.fragmenttest.childFragment.ChildFragment
import com.example.fragmenttest.databinding.FragmentHome1Binding
import com.example.fragmenttest.entity.Dialog
import com.example.fragmenttest.entity.StrTitle
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment1 : Fragment() {
    private lateinit var homeTableLayout:TableLayout
    private lateinit var homeViewPaper:ViewPager2
    private val strTitleList= listOf<String>("推荐","旅行","学习","美食","音乐")
    private val fragments= listOf(lazy { ChildFragment() }, lazy { ChildFragment() },lazy { ChildFragment()},lazy { ChildFragment()},lazy { ChildFragment()})
    private lateinit var binding:FragmentHome1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHome1Binding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=homeViewPaperAdapter()
        binding.homeViewPaper.adapter=adapter
        //binding.homeViewPaper.requestDisallowInterceptTouchEvent(true)
        TabLayoutMediator(binding.homeFragmentHeader,binding.homeViewPaper){
            tab,position->
            tab.text=strTitleList[position]
        }.attach()
    }

    inner class homeViewPaperAdapter:FragmentStateAdapter(this){
        override fun getItemCount(): Int {
            return strTitleList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position].value as ChildFragment
        }

    }
}