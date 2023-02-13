package com.acxdev.youkuslicing.ui

import android.content.Intent
import com.acxdev.commonFunction.common.base.BaseFragmentLib
import com.acxdev.youkuslicing.databinding.FragmentHomeBinding
import com.acxdev.commonFunction.adapter.OnClick
import com.acxdev.commonFunction.common.ConstantLib
import com.acxdev.commonFunction.util.ext.view.set
import com.acxdev.commonFunction.util.ext.view.setGrid
import com.acxdev.commonFunction.util.ext.view.setHStack
import com.acxdev.commonFunction.util.ext.view.toJson
import com.acxdev.youkuslicing.Data
import com.acxdev.youkuslicing.Data.homeBanner
import com.acxdev.youkuslicing.Data.populer
import com.acxdev.youkuslicing.model.Movies
import com.acxdev.youkuslicing.ui.row.RowSection
import com.acxdev.youkuslicing.ui.row.RowSlide
import com.acxdev.youkuslicing.ui.row.RowTop
import com.acxdev.youkuslicing.SectionStyle

class FragmentHome : BaseFragmentLib<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun FragmentHomeBinding.configureViews() {
        top.setHStack(RowTop(Data.topType(), object : OnClick<String> {
            override fun onItemClick(item: String, position: Int) {

            }
        }))

        val onClickMovies =  object : OnClick<Movies> {
            override fun onItemClick(item: Movies, position: Int) {
                Intent(requireContext(), ActivityMoviesDetail::class.java)
                    .putExtra(ConstantLib.DATA, item.toJson())
                    .also {
                        startActivity(it)
                    }
            }
        }
        sliderView.set(RowSlide(requireContext().homeBanner(), onClickMovies))
        populer.apply {
            name.text = "Populer"
            recycler.setGrid(RowSection(requireContext().populer(), onClickMovies, SectionStyle.POPULER),200F)
        }
        top10.apply {
            name.text = "Acara Top 10 di Lokasimu"
            recycler.setHStack(RowSection(requireContext().populer(), onClickMovies, SectionStyle.TOP10, false))
        }
        happyBirthday.apply {
            name.text = "✨Selamat Ulang Tahun🎂"
            recycler.setHStack(RowSection(requireContext().populer(), onClickMovies, SectionStyle.HAPPY_BIRTHDAY))
        }
        miniSeries.apply {
            name.text = "Mini Series"
            recycler.setHStack(RowSection(requireContext().populer(), onClickMovies, SectionStyle.HAPPY_BIRTHDAY))
        }
        romance.apply {
            name.text = "Kolosal Romantis❤️"
            recycler.setHStack(RowSection(requireContext().populer(), onClickMovies, SectionStyle.HAPPY_BIRTHDAY))
        }
        action.apply {
            name.text = "Membara! Film Aksi Penuh Semangat"
            recycler.setHStack(RowSection(requireContext().populer(), onClickMovies, SectionStyle.ACTION))
        }
        criminal.apply {
            name.text = "Film Kriminalitas? Mari Menonton"
            recycler.setHStack(RowSection(requireContext().populer(), onClickMovies, SectionStyle.ACTION))
        }
    }

    override fun FragmentHomeBinding.onClickListener() {

    }
}