package com.basaran.howmanypeopleinspace.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.basaran.howmanypeopleinspace.databinding.SpaceItemBinding
import com.basaran.howmanypeopleinspace.model.PeopleModel

class SpaceAdapter(private var spaceList: ArrayList<PeopleModel>) :
    RecyclerView.Adapter<SpaceAdapter.MyViewHolder>() {

    class MyViewHolder(val spaceitembinding: SpaceItemBinding) :
        RecyclerView.ViewHolder(spaceitembinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val spaceitembinding = SpaceItemBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(spaceitembinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val space = spaceList[position]

        holder.spaceitembinding.apply {
            txtcraft.text = "Uzay Aracı : "+space.craft
            txtad.text = "Astronot : "+space.name

        }
    }

    override fun getItemCount(): Int {
        return spaceList.size
    }
}