package com.example.fragmenttest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttest.R
import com.example.fragmenttest.entity.StrTitle

class StrTitleAdapter(val strTitleList: List<String>):RecyclerView.Adapter<StrTitleAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val smallTitle:TextView=view.findViewById(R.id.str_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StrTitleAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.str_item,parent,false)
        val viewHolder=ViewHolder(view)
        viewHolder.smallTitle.setOnClickListener {
            val position=viewHolder.adapterPosition
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: StrTitleAdapter.ViewHolder, position: Int) {
        holder.smallTitle.text=strTitleList[position]
    }

    override fun getItemCount(): Int {
        return strTitleList.size
    }
}