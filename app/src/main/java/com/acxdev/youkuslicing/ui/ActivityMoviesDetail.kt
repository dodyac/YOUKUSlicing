package com.acxdev.youkuslicing.ui

import android.content.Intent
import com.acxdev.commonFunction.adapter.OnClick
import com.acxdev.commonFunction.common.ConstantLib
import com.acxdev.commonFunction.common.base.BaseActivityLib
import com.acxdev.commonFunction.util.ext.toClass
import com.acxdev.commonFunction.util.ext.view.setHStack
import com.acxdev.commonFunction.util.ext.view.toJson
import com.acxdev.commonFunction.util.ext.view.visible
import com.acxdev.youkuslicing.Data.btsSample
import com.acxdev.youkuslicing.Data.populer
import com.acxdev.youkuslicing.Data.trailerSample
import com.acxdev.youkuslicing.ExoPlayerManager
import com.acxdev.youkuslicing.R
import com.acxdev.youkuslicing.SectionStyle
import com.acxdev.youkuslicing.databinding.ActivityMoviesDetailBinding
import com.acxdev.youkuslicing.model.Movies
import com.acxdev.youkuslicing.model.TrailerBTS
import com.acxdev.youkuslicing.ui.row.RowEpisode
import com.acxdev.youkuslicing.ui.row.RowSection
import com.acxdev.youkuslicing.ui.row.RowTrailerBTS
import com.google.android.material.elevation.SurfaceColors

class ActivityMoviesDetail : BaseActivityLib<ActivityMoviesDetailBinding>(ActivityMoviesDetailBinding::inflate) {
    private lateinit var exoPlayerManager: ExoPlayerManager

    override fun ActivityMoviesDetailBinding.configureViews() {
        window.navigationBarColor = getColor(R.color.black)
        val movie = intent.getStringExtra(ConstantLib.DATA).toClass(Movies::class.java)

        exoPlayerManager = ExoPlayerManager(this@ActivityMoviesDetail)
        exoPlayerManager.initializePlayer()
//        exoPlayerManager.playFromUrl(movie.episode[0].streamUrl, exoPlayer)
        exoPlayer.setSource(movie.episode[0].streamUrl)

        title.text = movie.title
        tag.text = movie.type.string

        episode.apply {
            name.text = "Episode"
            more.visible()
            recycler.setHStack(RowEpisode(movie.episode.toMutableList(), object : OnClick<Movies.Episode> {
                override fun onItemClick(item: Movies.Episode, position: Int) {
//                    exoPlayerManager.playFromUrl(item.streamUrl, exoPlayer)
                    exoPlayer.stopPlayer()
                    exoPlayer.setSource(item.streamUrl)
                }
            }))
        }

        val onClickTrailerBTS =  object : OnClick<TrailerBTS> {
            override fun onItemClick(item: TrailerBTS, position: Int) {
//                exoPlayerManager.playFromUrl(item.streamUrl, exoPlayer)
                exoPlayer.stopPlayer()
                exoPlayer.setSource(item.streamUrl)
            }
        }
        bts.apply {
            name.text = "☠️BTS☠️"
            more.visible()
            recycler.setHStack(RowTrailerBTS(btsSample(), onClickTrailerBTS))
        }
        trailer.apply {
            name.text = "Trailer"
            more.visible()
            recycler.setHStack(RowTrailerBTS(trailerSample(), onClickTrailerBTS,true))
        }

        val onClickMovies =  object : OnClick<Movies> {
            override fun onItemClick(item: Movies, position: Int) {
                Intent(this@ActivityMoviesDetail, ActivityMoviesDetail::class.java)
                    .putExtra(ConstantLib.DATA, item.toJson())
                    .also {
                        startActivity(it)
                        finish()
                    }
            }
        }
        forYou.apply {
            name.text = "For you"
            more.visible()
            recycler.setHStack(RowSection(populer(), onClickMovies, SectionStyle.ACTION))
        }
    }

    override fun ActivityMoviesDetailBinding.onClickListener() {
        back.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayerManager.releasePlayer()
        scopeLayout {
            exoPlayer.stopPlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        exoPlayerManager.releasePlayer()
        scopeLayout {
            exoPlayer.stopPlayer()
        }
    }
}