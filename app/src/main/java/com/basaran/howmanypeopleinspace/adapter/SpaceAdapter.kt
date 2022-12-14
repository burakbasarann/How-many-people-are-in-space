package com.basaran.howmanypeopleinspace.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.basaran.howmanypeopleinspace.R
import com.basaran.howmanypeopleinspace.model.CraftInfo
import com.basaran.howmanypeopleinspace.model.PeopleModel

class SpaceAdapter(private var spaceList: List<PeopleModel>, private val listener: CraftInfo, var context : Context) :
    RecyclerView.Adapter<SpaceAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val craftName1: TextView = itemView.findViewById(R.id.txtcraft)
        val peopleName2: TextView = itemView.findViewById(R.id.txtad)
        init {
            itemView.setOnClickListener (this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            val craftName = spaceList[adapterPosition].craft
            val peopleName =  spaceList[adapterPosition].name
            if (position != RecyclerView.NO_POSITION) {
                listener.passData(position,craftName, peopleName)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.space_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val space = spaceList.get(position)
        holder.craftName1.text = context.getString(R.string.gemi_adi, space.craft)
        holder.peopleName2.text = context.getString(R.string.insan_adi, space.name)
    }

    override fun getItemCount(): Int {
        return spaceList.size
    }
}