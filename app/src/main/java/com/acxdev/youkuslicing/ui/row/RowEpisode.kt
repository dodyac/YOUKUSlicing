package com.acxdev.youkuslicing.ui.row

import com.acxdev.commonFunction.adapter.BaseAdapterLib
import com.acxdev.commonFunction.adapter.OnClick
import com.acxdev.commonFunction.util.ext.view.backgroundTint
import com.acxdev.commonFunction.util.ext.view.gone
import com.acxdev.commonFunction.util.ext.view.visible
import com.acxdev.commonFunction.util.ext.view.visibleIf
import com.acxdev.youkuslicing.R
import com.acxdev.youkuslicing.model.Movies
import com.acxdev.youkuslicing.databinding.RowEpisodeBinding

class RowEpisode(list: MutableList<Movies.Episode>, private val onClick: OnClick<Movies.Episode>)
    : BaseAdapterLib<RowEpisodeBinding, Movies.Episode>(RowEpisodeBinding::inflate, list) {

    private var playedEpisodeIndex = 0

    override fun ViewHolder<RowEpisodeBinding>.bind(item: Movies.Episode) {
        scopeLayout {
            title.text = (adapterPosition + 1).toString()
            type.visibleIf(item.type != Movies.EpisodeType.FREE)
            type.text = item.type.string
            when(item.type) {
                Movies.EpisodeType.VIP -> {
                    type.setTextColor(context.getColor(R.color.vipText))
                    type.backgroundTint(R.color.vipBackground)
                }
                Movies.EpisodeType.TRAILER -> {
                    type.setTextColor(context.getColor(R.color.trailerText))
                    type.backgroundTint(R.color.trailerBackground)
                }
                Movies.EpisodeType.FREE -> Unit
            }
            if(adapterPosition == playedEpisodeIndex) {
                lottie.visible()
                lottie.playAnimation()
                title.gone()
            } else {
                lottie.gone()
                lottie.cancelAnimation()
                title.visible()
            }


            root.setOnClickListener {
                if (playedEpisodeIndex >= 0) {
                    notifyItemChanged(playedEpisodeIndex)
                }
                playedEpisodeIndex = adapterPosition
                notifyItemChanged(playedEpisodeIndex)
                onClick.onItemClick(item, adapterPosition)
            }
        }
    }
}