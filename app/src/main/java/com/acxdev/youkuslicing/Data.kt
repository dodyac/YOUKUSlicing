package com.acxdev.youkuslicing

import android.content.Context
import com.acxdev.youkuslicing.model.Movies
import com.acxdev.youkuslicing.model.TrailerBTS

object Data {

    fun topType(): MutableList<String> {
        val list = mutableListOf<String>()
        list.add("Beranda")
        list.add("Episode")
        list.add("Film")

        return list
    }

    fun Context.homeBanner(): MutableList<Movies> {
        val list = mutableListOf<Movies>()
        list.add(
            Movies(
            "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2022/9/24/6cec27f1-71fc-4997-b55b-c74529abb8ec.jpg",
            "Pembalasan Dendam Sang Pengantin",
            sampleEpisodes(), getString(R.string.loremIpsum), Type.EXPRESS)
        )
        list.add(
            Movies(
            "https://watchasian.se/wp-content/uploads/2023/02/wzmAO2esRNfSwzD36amWZWTl4ZC.jpg",
            "Memulai Kehidupan yang Benar",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.EXPRESS)
        )
        list.add(
            Movies(
            "https://image.tmdb.org/t/p/w500/kZXvlreB80Qn0IaaR4fbu7qnxW5.jpg",
            "Pria Baik Beruntung",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.VIP)
        )
        list.add(
            Movies(
            "https://layarhijau.com/wp-content/uploads/2022/04/the-blue-whisper-part-2.jpg",
            "The Blue Whisper Part 2",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.EXPRESS)
        )
        list.add(
            Movies(
            "https://pbs.twimg.com/media/EB2GmZNWkAA7F1I.jpg",
            "Another Me",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.VIP)
        )
        list.add(
            Movies(
            "https://theoddonee.files.wordpress.com/2021/06/chinese-drama1.jpg",
            "Meteor Garden",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.VIP)
        )
        list.add(
            Movies(
            "https://i.pinimg.com/736x/d1/79/6f/d1796f92fb6df49158e2b2d63c9229d0.jpg",
            "The Secret of Love",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.NONE)
        )

        return list
    }

    fun Context.populer(): MutableList<Movies> {
        val list = mutableListOf<Movies>()
        list.add(
            Movies(
            "https://media.suara.com/pictures/970x544/2023/01/30/88912-wulin-heroes-weibo.jpg",
            "Pahlawan Dunia Persilatan",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.VIP)
        )
        list.add(
            Movies(
            "https://i.ytimg.com/vi/o5_6dHVm_HE/maxresdefault.jpg",
            "Pembalasan Dendam Sang Pengantin",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.VIP)
        )
        list.add(
            Movies(
            "https://i.ytimg.com/vi/zWJyMGu2bWs/maxresdefault.jpg",
            "Pemantik dan Tuan Putri",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.EXPRESS)
        )
        list.add(
            Movies(
            "https://layarhijau.com/wp-content/uploads/2022/04/the-blue-whisper-part-2.jpg",
            "The Blue Whisper Part 2",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.VIP)
        )
        list.add(
            Movies(
            "https://i.ytimg.com/vi/VNemf4gKeDA/maxresdefault.jpg",
            "Raja Penembak Jitu",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.EXPRESS)
        )
        list.add(
            Movies(
            "https://theoddonee.files.wordpress.com/2021/06/chinese-drama1.jpg",
            "Meteor Garden",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.VIP)
        )
        list.add(
            Movies(
            "https://i.pinimg.com/736x/d1/79/6f/d1796f92fb6df49158e2b2d63c9229d0.jpg",
            "The Secret of Love",
                sampleEpisodes(), getString(R.string.loremIpsum), Type.NONE)
        )

        return list
    }

    private const val streamURL = "http://sample.vodobox.net/skate_phantom_flex_4k/skate_phantom_flex_4k.m3u8"

    private fun sampleEpisodes(): List<Movies.Episode> {
        val list = mutableListOf<Movies.Episode>()

        list.add(Movies.Episode("Episode 1", streamURL))
        list.add(Movies.Episode("Episode 2", streamURL))
        list.add(Movies.Episode("Episode 3", streamURL))
        list.add(Movies.Episode("Episode 4", streamURL))
        list.add(Movies.Episode("Episode 5", streamURL))
        list.add(Movies.Episode("Episode 6", streamURL))
        list.add(Movies.Episode("Episode 7", streamURL, Movies.EpisodeType.TRAILER))
        list.add(Movies.Episode("Episode 8", streamURL, Movies.EpisodeType.TRAILER))
        list.add(Movies.Episode("Episode 9", streamURL, Movies.EpisodeType.VIP))
        list.add(Movies.Episode("Episode 10", streamURL, Movies.EpisodeType.VIP))
        list.add(Movies.Episode("Episode 11", streamURL, Movies.EpisodeType.VIP))
        list.add(Movies.Episode("Episode 12", streamURL, Movies.EpisodeType.VIP))
        list.add(Movies.Episode("Episode 13", streamURL, Movies.EpisodeType.VIP))
        list.add(Movies.Episode("Episode 14", streamURL, Movies.EpisodeType.VIP))
        return list
    }

    fun trailerSample(): MutableList<TrailerBTS> {
        val list = mutableListOf<TrailerBTS>()
        list.add(TrailerBTS("Trailer Ep10", streamURL, "https://t-2.tstatic.net/mataraman/foto/bank/images/Poster-Drama-China-Maids-Revenge.jpg"))
        list.add(TrailerBTS("Trailer Ep11", streamURL, "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/183206e18b53e32fb7ba41919a0569c8a3861b866b649461e68e331cd7c512fd._RI_V_TTW_.jpg"))
        list.add(TrailerBTS("Trailer Ep12", streamURL, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStzHcuTHW1b97RV-xXhgvO62wWb7RHg2Zhow&usqp=CAU"))
        list.add(TrailerBTS("Trailer Ep13", streamURL, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBMfpb-siMeHic7okBwLdhUnugp0KHdGUdHw&usqp=CAU"))
        list.add(TrailerBTS("Trailer Ep14", streamURL, "https://t-2.tstatic.net/mataraman/foto/bank/images/Poster-Drama-China-Maids-Revenge.jpg"))
        list.add(TrailerBTS("Trailer Ep15", streamURL, "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/183206e18b53e32fb7ba41919a0569c8a3861b866b649461e68e331cd7c512fd._RI_V_TTW_.jpg"))

        return list
    }

    fun btsSample(): MutableList<TrailerBTS> {
        val list = mutableListOf<TrailerBTS>()
        list.add(TrailerBTS("Hubungan cinta-benci Mu bersaudara", streamURL, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStzHcuTHW1b97RV-xXhgvO62wWb7RHg2Zhow&usqp=CAU"))
        list.add(TrailerBTS("Hubungan cinta-benci Mu bersaudara2", streamURL, "https://t-2.tstatic.net/mataraman/foto/bank/images/Poster-Drama-China-Maids-Revenge.jpg"))
        list.add(TrailerBTS("Cover majalah Jiangcheng", streamURL, "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/183206e18b53e32fb7ba41919a0569c8a3861b866b649461e68e331cd7c512fd._RI_V_TTW_.jpg"))
        list.add(TrailerBTS("Interaksi Manis WeiQu CP", streamURL, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBMfpb-siMeHic7okBwLdhUnugp0KHdGUdHw&usqp=CAU"))
        list.add(TrailerBTS("Foto pose manis pasangan", streamURL, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStzHcuTHW1b97RV-xXhgvO62wWb7RHg2Zhow&usqp=CAU"))
        list.add(TrailerBTS("OST", streamURL, "https://t-2.tstatic.net/mataraman/foto/bank/images/Poster-Drama-China-Maids-Revenge.jpg"))

        return list
    }
}