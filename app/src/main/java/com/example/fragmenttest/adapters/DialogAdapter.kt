package com.example.fragmenttest.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttest.DialogActivity
import com.example.fragmenttest.MainActivity
import com.example.fragmenttest.R
import com.example.fragmenttest.entity.Dialog

class DialogAdapter(val dialogList:List<Dialog>):RecyclerView.Adapter<DialogAdapter.ViewHolder>() {


    class ViewHolder(view : View):RecyclerView.ViewHolder(view){
        val dialogImage:ImageView=view.findViewById(R.id.item_image_view)
        val dialogTitle:TextView=view.findViewById(R.id.item_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_dialogs,parent,false)
        val viewHolder=ViewHolder(view)
        //RecyclerView最外层布局
        viewHolder.itemView.setOnClickListener {
            val position=viewHolder.adapterPosition
            val intent=Intent(view.context,DialogActivity::class.java)
            intent.putExtra("position",position)
            intent.putExtra("title",dialogList[position].title)
            view.context.startActivity(intent)
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
      return dialogList.size
    }

    //这这里进行数据绑定，使其控件进行赋值
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val dialog=dialogList[position]
        holder.dialogImage.setImageResource(dialog.imageId)
        holder.dialogTitle.text=dialog.title
    }
}