package com.wonmirzo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.wonmirzo.CitySelectionBottomSheet
import com.wonmirzo.CitySelectionBottomSheet.Companion.ACTION_FROM
import com.wonmirzo.CitySelectionBottomSheet.Companion.ACTION_TO
import com.wonmirzo.R
import com.wonmirzo.adapter.SliderAdapter
import com.wonmirzo.model.Banner
import org.w3c.dom.Text

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var isDrawerOpen = false
    private val adapter by lazy { SliderAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI(view)
    }

    private fun setupUI(view: View) {
        val btnMenu = view.findViewById<ImageView>(R.id.btnMenu)
        val drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)
        val slider = view.findViewById<ViewPager2>(R.id.slider)
        val tvFrom = view.findViewById<TextView>(R.id.tvFrom)
        val tvTo = view.findViewById<TextView>(R.id.tvTo)
        val indicator = view.findViewById<TabLayout>(R.id.tabIndicator)

        tvFrom.setOnClickListener {
            //tvFrom.setBackgroundResource(R.drawable.bg_edit_text_enable)
            openRegionSheet(ACTION_FROM)
        }

        tvTo.setOnClickListener {
            CitySelectionBottomSheet(ACTION_TO)
        }

        setData()
        slider.adapter = adapter

        TabLayoutMediator(indicator, slider) { _, _ ->
        }.attach()

        slider.offscreenPageLimit = 3
        slider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        btnMenu.setOnClickListener {
            drawerLayout.open()
        }
    }

    private fun openRegionSheet(type: Int) {
        val dialog = CitySelectionBottomSheet(type)
        dialog.show((requireActivity().supportFragmentManager), null)
    }

    private fun setData() {
        val list = ArrayList<Banner>()
        list.add(
            Banner(
                "https://images.pexels.com/photos/462867/pexels-photo-462867.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Prosta"
            )
        )
        list.add(
            Banner(
                "https://images.pexels.com/photos/314374/pexels-photo-314374.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Prosta"
            )
        )
        list.add(
            Banner(
                "https://images.pexels.com/photos/2399254/pexels-photo-2399254.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Prosta"
            )
        )

        adapter.submitData(list)
    }
}