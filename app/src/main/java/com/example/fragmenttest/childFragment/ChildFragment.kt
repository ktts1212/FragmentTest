package com.example.fragmenttest.childFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmenttest.R


class ChildFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child, container, false)
    }

    companion object{
        fun newInstance(title:String):ChildFragment{
            val args = Bundle()
            val fragment = ChildFragment()
            args.putString("position",title)
            fragment.arguments = args
            return fragment
        }
    }
}