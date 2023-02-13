package com.acxdev.youkuslicing.model

import com.acxdev.youkuslicing.Type

data class Movies(
    val image: String,
    val title: String,
    val episode: List<Episode>,
    val synopsis: String,
    val type: Type = Type.NONE
) {
    data class Episode(val title: String, val streamUrl: String, val type: EpisodeType = EpisodeType.FREE)

    enum class EpisodeType(val string: String) {
        FREE("Free"),
        VIP("VIP"),
        TRAILER("Trailer")
    }
}