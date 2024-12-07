package com.straccion.webmotos.sections

import androidx.compose.runtime.*
import com.straccion.webmotos.components.PortfolioCard
import com.straccion.webmotos.components.SectionTitle
import com.straccion.webmotos.models.Portfolio
import com.straccion.webmotos.models.Section
import com.straccion.webmotos.styles.PortfolioArrowIconStyle
import com.straccion.webmotos.utils.Constants.SECTION_WIDTH
import com.straccion.webmotos.utils.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.ResponsiveValues
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.GridAutoFlow
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement


@Composable
fun PortafolioSection() {
    Box(
        modifier = Modifier
            .id(Section.Portfolio.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 80.px),
        contentAlignment = Alignment.Center
    ) {
        PortfolioContent()
    }
}

@Composable
fun PortfolioContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(),
            section = Section.Portfolio
        )
        PortfolioCards()
    }
}

@Composable
fun PortfolioCards() {
    var currentIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.px),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Tarjetas visibles
            Row(
                modifier = Modifier
                    .fillMaxWidth() // Ajusta el ancho visible
                    .height(390.px)
                    .overflow(Overflow.Hidden), // Oculta elementos fuera del contenedor
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Portfolio.entries.subList(
                    currentIndex,
                    (currentIndex + 3).coerceAtMost(Portfolio.entries.size) // Máximo 3 visibles
                ).forEach  { portfolio ->
                    PortfolioCard(
                        portfolio = portfolio,
                    )
                }
            }
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FaArrowLeft(
            modifier = PortfolioArrowIconStyle.toModifier()
                .margin(leftRight = 20.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    if (currentIndex > 0) currentIndex--
                },
            size = IconSize.LG
        )
        FaArrowRight(
            modifier = PortfolioArrowIconStyle.toModifier()
                .cursor(Cursor.Pointer)
                .onClick {
                    if (currentIndex < Portfolio.entries.size - 3) currentIndex++
                },
            size = IconSize.LG
        )
    }
}

