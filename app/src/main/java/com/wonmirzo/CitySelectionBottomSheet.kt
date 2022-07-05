package com.wonmirzo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wonmirzo.adapter.CitySelectionAdapter
import com.wonmirzo.model.Region

class CitySelectionBottomSheet(val type: Int) : BottomSheetDialogFragment() {
    private val adapter by lazy { CitySelectionAdapter() }

    companion object {
        const val ACTION_FROM = 0
        const val ACTION_TO = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context)
            .inflate(R.layout.city_selection_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtType = view.findViewById<TextView>(R.id.txtType)
        val rvRegion = view.findViewById<RecyclerView>(R.id.recyclerView)
        txtType.text = if (type == ACTION_FROM) "Qayerdan" else "Qayerga?"

        val layoutManager = LinearLayoutManager(requireContext())
        rvRegion.layoutManager = layoutManager
        rvRegion.adapter = adapter
        adapter.itemClick = {

        }

        val list = ArrayList<Region>()
        list.add(Region("Xorazm"))
        list.add(Region("Qashqadaryo"))
        list.add(Region("Toshkent"))
        list.add(Region("Buxoro"))
        list.add(Region("Samarqand"))
        adapter.submitData(list)
    }
}