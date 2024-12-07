package com.straccion.webmotos.sections

import androidx.compose.runtime.*
import com.straccion.webmotos.components.SectionTitle
import com.straccion.webmotos.components.SkillBar
import com.straccion.webmotos.models.Section
import com.straccion.webmotos.models.Skills
import com.straccion.webmotos.models.Theme
import com.straccion.webmotos.utils.Constants.FONT_FAMILY
import com.straccion.webmotos.utils.Constants.SECTION_WIDTH
import com.straccion.webmotos.utils.ObserveViewportEntered
import com.straccion.webmotos.utils.Res
import com.straccion.webmotos.utils.animateNumbers
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px, leftRight = 25.px),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            )
            .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(numColumns = numColumns(base = 1, md = 2)) {
            if (breakpoint >= Breakpoint.MD) {
                AboutImage()
            }
            AboutMe()
        }
    }
}

@Composable
fun AboutImage() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(80.percent),
            src = Res.Image.about,
            description = "About Image"
        )
    }
}

@Composable
fun AboutMe() {
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedPercentage = remember { mutableStateListOf(0, 0, 0, 0, 0, 0, 0) }

    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 550.0,
        onViewportEntered = {
            viewportEntered = true
            Skills.values().forEach { skills ->
                scope.launch {
                    animateNumbers(
                        number = skills.percentage.value.toInt(),
                        onUpdate = {
                            animatedPercentage[skills.ordinal] = it
                        }
                    )
                }
            }
        }
    )
    var isOpacity by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(section = Section.About)
        P(
            attrs = Modifier
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .fontStyle(FontStyle.Italic)
                .color(Theme.Secondary.rgb)
                .opacity(if (isOpacity) 90.percent else 50.percent)
                .onMouseEnter { isOpacity = true }
                .onMouseLeave { isOpacity = false }
                .styleModifier {
                    transition(
                        Transition.of("opacity", 300.ms),
                    )
                }
                .toAttrs()
        ) {
            Text(
                "Aqui va la descripcion de por que contratarme"
            )
        }
        Skills.values().forEach { skills ->
            SkillBar(
                name = skills.title,
                index = skills.ordinal,
                percentage = if (viewportEntered) skills.percentage else 0.percent,
                animatedPercetage = if (viewportEntered)animatedPercentage[skills.ordinal] else 0
            )
        }
    }
}