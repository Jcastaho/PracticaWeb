package com.straccion.webmotos.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String, val rgb: CSSColorValue
) {
    Primary(hex = "#00A78E", rgb = rgb(r = 0, g = 167, b = 142)),
    Secondary (hex = "#121D34", rgb = rgb( 18, 29, 52)),
    Gray (hex = "#CFCFCF", rgb = rgb (r= 207, g = 207 , b = 2071 )),
    LightGray (hex = "#EDEDED", rgb = rgb(r= 237, g = 237 , b = 237 )),
    LighterGray (hex = "#FFFFFF", rgb = rgb(r = 252, g = 252 , b = 252 ))
}