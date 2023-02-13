package com.acxdev.youkuslicing.ui

import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.acxdev.commonFunction.adapter.ViewPager2Adapter
import com.acxdev.commonFunction.common.base.BaseActivityLib
import com.acxdev.commonFunction.util.toast
import com.acxdev.youkuslicing.R
import com.acxdev.youkuslicing.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivityLib<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private var doubleBackToExitPressedOnce = false

    override fun ActivityMainBinding.configureViews() {
        window.navigationBarColor = getColor(R.color.black)
        val pager2Adapter = ViewPager2Adapter(this@MainActivity)

        pager2Adapter.sets(
            FragmentHome(),
            BlankFragment(),
            BlankFragment(),
            BlankFragment()
        )

        viewPager.adapter = pager2Adapter
        viewPager.isUserInputEnabled = false
        viewPager.offscreenPageLimit = 4

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNav.menu.getItem(position).isChecked = true
            }
        })
    }

    override fun ActivityMainBinding.onClickListener() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> viewPager.currentItem = 0
                R.id.nav_find -> viewPager.currentItem = 1
                R.id.nav_download -> viewPager.currentItem = 2
                R.id.nav_me -> viewPager.currentItem = 3
            }
            true
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        doubleBackToExitPressedOnce = true

        toast("Press again to quit the app.")

        lifecycleScope.launch(Dispatchers.IO){
            delay(2000L)
            doubleBackToExitPressedOnce = false
        }
    }
}