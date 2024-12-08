package com.straccion.webmotos.sections

import androidx.compose.runtime.*
import com.straccion.webmotos.components.SocialBar
import com.straccion.webmotos.models.Section
import com.straccion.webmotos.models.Theme
import com.straccion.webmotos.utils.Constants.FONT_FAMILY
import com.straccion.webmotos.utils.Constants.SECTION_WIDTH
import com.straccion.webmotos.utils.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun FooterSection(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px)
            .backgroundColor(Theme.LightGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        FooterContent()
    }
}

@Composable
fun FooterContent(){
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(100.px),
            src = Res.Image.logo,
            description = "Logo Image"
        )
       if(breakpoint > Breakpoint.SM){
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .margin(top = 40.px),
               horizontalArrangement = Arrangement.Center
           ) {
               FooterMenu()
           }
       } else {
           Column(
               modifier = Modifier.fillMaxWidth()
                   .margin(top = 20.px),
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               FooterMenu(row = false)
           }
       }
        SocialBar(row = true)
    }
}

@Composable
fun FooterMenu(row: Boolean = true){
    var hoveredSection by remember { mutableStateOf<Section?>(null) }
    Section.values().take(6).forEach { section ->
        Link(
            modifier = Modifier
                .padding(right = if(row) 20.px else 0.px,
                    bottom = if (row) 0.px else 20.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(12.px)
                .fontWeight(FontWeight.Normal)
                .textDecorationLine(TextDecorationLine.None)
                .color(if (hoveredSection == section) Colors.Green else Colors.Black)
                .onMouseEnter { hoveredSection = section }
                .onMouseLeave { hoveredSection = null },
            path = section.path,
            text = section.title
        )
    }
}