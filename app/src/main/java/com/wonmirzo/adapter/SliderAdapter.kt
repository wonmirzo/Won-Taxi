package com.wonmirzo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wonmirzo.R
import com.wonmirzo.model.Banner

class SliderAdapter : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
    private val sliderItems: ArrayList<Banner> = ArrayList()

    inner class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val banner = sliderItems[adapterPosition]
            val title = itemView.findViewById<TextView>(R.id.title)
            val image = itemView.findViewById<ImageView>(R.id.image)

            title.text = banner.title
            Picasso.get().load(banner.image).into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_slider, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = sliderItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(list: List<Banner>) {
        sliderItems.addAll(list)
        notifyDataSetChanged()
    }
}