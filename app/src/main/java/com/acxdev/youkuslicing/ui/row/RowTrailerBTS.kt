package com.acxdev.youkuslicing.ui.row

import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.acxdev.commonFunction.adapter.BaseAdapterLib
import com.acxdev.commonFunction.adapter.OnClick
import com.acxdev.commonFunction.util.ext.view.backgroundTint
import com.acxdev.commonFunction.util.ext.view.setImageUrl
import com.acxdev.commonFunction.util.ext.view.visible
import com.acxdev.commonFunction.util.ext.view.visibleIf
import com.acxdev.youkuslicing.R
import com.acxdev.youkuslicing.model.Movies
import com.acxdev.youkuslicing.SectionStyle
import com.acxdev.youkuslicing.Type
import com.acxdev.youkuslicing.databinding.RowSectionBinding
import com.acxdev.youkuslicing.model.TrailerBTS

class RowTrailerBTS(list: MutableList<TrailerBTS>, private val onClick: OnClick<TrailerBTS>, private val isTrailer: Boolean = false,
                    private val sectionStyle: SectionStyle = SectionStyle.HAPPY_BIRTHDAY,)
    : BaseAdapterLib<RowSectionBinding, TrailerBTS>(RowSectionBinding::inflate, list) {

    override fun ViewHolder<RowSectionBinding>.bind(item: TrailerBTS) {
        scopeLayout {
            val param = LinearLayout.LayoutParams(
                sectionStyle.parentWidth?.let { context.resources.getDimensionPixelSize(it) } ?: run {
                    LinearLayout.LayoutParams.MATCH_PARENT
                },
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            root.layoutParams = param

            val paramImage = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                context.resources.getDimensionPixelSize(sectionStyle.imageHeight)
            )
            image.layoutParams = paramImage

            image.setImageUrl(item.image)

            title.text = item.title
            tag.apply {
                visibleIf(isTrailer)
                backgroundTint(R.color.trailer)
                text = "Trailer"
                setTextColor(context.getColor(R.color.black))
            }

            root.setOnClickListener {
                onClick.onItemClick(item, 0)
            }
        }
    }
}