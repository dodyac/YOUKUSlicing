package com.acxdev.youkuslicing

enum class SectionStyle(val parentWidth: Int?, val imageHeight: Int) {
    POPULER(null, R.dimen.populerHeight),
    TOP10(R.dimen.top10Width, R.dimen.top10Height),
    HAPPY_BIRTHDAY(R.dimen.hBirthdayWidth, R.dimen.hBirthdayHeight),
    ACTION(R.dimen.actionWidth, R.dimen.actionHeight),
}