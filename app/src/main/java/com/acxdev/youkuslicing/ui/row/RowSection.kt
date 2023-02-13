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

class RowSection(list: MutableList<Movies>, private val onClick: OnClick<Movies>, private val sectionStyle: SectionStyle,
                 private val textVisible: Boolean = true)
    : BaseAdapterLib<RowSectionBinding, Movies>(RowSectionBinding::inflate, list) {

    override fun ViewHolder<RowSectionBinding>.bind(item: Movies) {
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

            title.apply {
                visibleIf(textVisible)
                text = item.title
            }
            tag.apply {
                visibleIf(item.type != Type.NONE)
                text = item.type.string
            }

            root.setOnClickListener {
                onClick.onItemClick(item, 0)
            }
        }
    }
}