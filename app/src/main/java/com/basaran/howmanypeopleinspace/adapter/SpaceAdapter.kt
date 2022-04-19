package com.basaran.howmanypeopleinspace.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.basaran.howmanypeopleinspace.databinding.SpaceItemBinding
import com.basaran.howmanypeopleinspace.model.PeopleModel

class SpaceAdapter(private var spaceList: List<PeopleModel>) :
    RecyclerView.Adapter<SpaceAdapter.MyViewHolder>() {

    inner class MyViewHolder(spaceItemBinding: SpaceItemBinding) : RecyclerView.ViewHolder(spaceItemBinding.root){
        var spaceItemBinding: SpaceItemBinding
        init {
            this.spaceItemBinding = spaceItemBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val spaceItemBinding = SpaceItemBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(spaceItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val space = spaceList.get(position)
        val t = holder.spaceItemBinding
        t.spaceList = space

    }

    override fun getItemCount(): Int {
        return spaceList.size
    }
}