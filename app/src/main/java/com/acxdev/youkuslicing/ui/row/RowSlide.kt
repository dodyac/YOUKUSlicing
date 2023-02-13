package com.acxdev.youkuslicing.ui.row

import com.acxdev.commonFunction.adapter.BaseSliderLib
import com.acxdev.commonFunction.adapter.OnClick
import com.acxdev.commonFunction.util.ext.view.setImageUrl
import com.acxdev.youkuslicing.model.Movies
import com.acxdev.youkuslicing.databinding.RowSlideBinding

class RowSlide(list: MutableList<Movies>, private val onClick: OnClick<Movies>) :
    BaseSliderLib<RowSlideBinding, Movies>(RowSlideBinding::inflate, list) {

    override fun ViewHolder<RowSlideBinding>.bind(item: Movies) {
        scopeLayout {
            image.setImageUrl(item.image)
            title.text = item.title

            root.setOnClickListener {
                onClick.onItemClick(item, 0)
            }
        }
    }
}