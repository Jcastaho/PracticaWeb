package com.straccion.webmotos.styles

import com.straccion.webmotos.models.Theme
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.cssRule
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px


val iconBoxStyle = CssStyle {
    base {
        Modifier
            .border(
                width = 2.px, // Grosor del borde
                color = Theme.LighterGray.rgb,
                style = LineStyle.Solid // Estilo del borde (puede ser Solid, Dashed, etc.)
            )
            .backgroundColor(Colors.White)
            .transition(
                Transition.of("border", 300.ms)
            )

    }
    hover {
        Modifier
            .border(
                width = 2.px, // Grosor del borde
                color = Theme.Primary.rgb,
                style = LineStyle.Solid // Estilo del borde (puede ser Solid, Dashed, etc.)
            )
            .backgroundColor(Theme.Primary.rgb)
    }
    cssRule(" > #iconBox"){
        Modifier
            .backgroundColor(Colors.Transparent)
    }
    cssRule(":hover > #iconBox"){
        Modifier
            .backgroundColor(Colors.White)
    }
    cssRule(" > p"){
        Modifier
            .color(Theme.Secondary.rgb)
    }
    cssRule(":hover > p"){
        Modifier
            .color(Colors.White)
    }
}
