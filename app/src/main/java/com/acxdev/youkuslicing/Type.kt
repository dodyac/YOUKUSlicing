package com.acxdev.youkuslicing

import com.acxdev.commonFunction.util.ext.emptyString

enum class Type(val string: String) {
    EXPRESS("Express"),
    VIP("VIP"),
    NONE(emptyString())
}