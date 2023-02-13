package com.acxdev.youkuslicing.ui.row

import android.graphics.Typeface
import com.acxdev.commonFunction.adapter.BaseAdapterLib
import com.acxdev.commonFunction.adapter.OnClick
import com.acxdev.youkuslicing.R
import com.acxdev.youkuslicing.databinding.RowTopBinding

class RowTop(list: MutableList<String>, val onClick: OnClick<String>) :
    BaseAdapterLib<RowTopBinding, String>(RowTopBinding::inflate, list) {

    private var clickedIndex = 0

    override fun ViewHolder<RowTopBinding>.bind(item: String) {
        scopeLayout {
            title.apply {
                text = item
                if (clickedIndex == adapterPosition) {
                    setTextColor(context.getColor(R.color.white))
                    setTypeface(null, Typeface.BOLD)
                } else {
                    setTextColor(context.getColor(com.acxdev.shimmer.R.color.default_color))
                    setTypeface(null, Typeface.NORMAL)
                }
                setOnClickListener {
                    if (clickedIndex >= 0) {
                        notifyItemChanged(clickedIndex)
                    }
                    clickedIndex = adapterPosition
                    notifyItemChanged(clickedIndex)
                    onClick.onItemClick(item, adapterPosition)
                }
            }
        }
    }
}