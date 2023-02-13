package com.acxdev.youkuslicing

import android.content.Context
import android.net.Uri
import android.view.TextureView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class ExoPlayerManager(private val context: Context) {
    private var player: SimpleExoPlayer? = null

    fun initializePlayer() {
        player = SimpleExoPlayer.Builder(context).build()
    }

    fun playFromUrl(url: String, videoView: TextureView) {
        val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
            context,
            Util.getUserAgent(context, "ExoPlayerManager")
        )
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(Uri.parse(url)))
        player?.setVideoTextureView(videoView)
        player?.prepare(mediaSource)
        player?.playWhenReady = true
    }

    fun releasePlayer() {
        player?.let {
            it.stop()
            it.release()
        }
        player = null
    }
}