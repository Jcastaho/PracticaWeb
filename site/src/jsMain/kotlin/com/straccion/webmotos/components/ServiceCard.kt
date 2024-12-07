package com.straccion.webmotos.components

import androidx.compose.runtime.*
import com.straccion.webmotos.models.Service
import com.straccion.webmotos.models.Theme
import com.straccion.webmotos.styles.iconBoxStyle
import com.straccion.webmotos.utils.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text



@Composable
fun ServiceCard(service: Service) {
    var isModifier by remember { mutableStateOf(false) }
    val borderColor = if (isModifier) Theme.Primary.rgb else Theme.LighterGray.rgb
    Column(
        modifier = iconBoxStyle.toModifier()
            .maxWidth(300.px)
            .margin(all = 20.px)
            .padding(all = 20.px)
    ) {
        Box(
            modifier = Modifier
                .id("iconBox")
                .padding(all = 10.px)
                .margin(bottom = 20.px)
                .border(
                    width = 2.px, // Grosor del borde
                    color = Theme.Primary.rgb,
                    style = LineStyle.Solid // Estilo del borde (puede ser Solid, Dashed, etc.)
                )
                .borderRadius(
                    topLeft = 20.px,
                    topRightAndBottomLeft = 20.px,
                    bottomRight = 0.px
                )
        ) {
            Image(
                modifier = Modifier.size(40.px),
                src = service.icon,
                description = service.imageDesc
            )
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 10.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            Text(service.title)
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 10.px, bottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text(service.description)
        }
    }
}
