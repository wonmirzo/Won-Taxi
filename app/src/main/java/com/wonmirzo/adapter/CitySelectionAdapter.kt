package com.wonmirzo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wonmirzo.R
import com.wonmirzo.model.Region

class CitySelectionAdapter : RecyclerView.Adapter<CitySelectionAdapter.ViewHolder>() {
    private val regionItems: ArrayList<Region> = ArrayList()
    lateinit var itemClick: ((Region) -> Unit)

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val region = regionItems[adapterPosition]
            val title = itemView.findViewById<TextView>(R.id.name)
            val root = itemView.findViewById<LinearLayout>(R.id.llRoot)

            root.setOnClickListener {
                itemClick.invoke(region)
            }

            title.text = region.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_city_selection, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = regionItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(list: List<Region>) {
        regionItems.addAll(list)
        notifyDataSetChanged()
    }
}