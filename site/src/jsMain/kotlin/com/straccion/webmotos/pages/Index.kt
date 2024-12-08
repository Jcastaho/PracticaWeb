package com.straccion.webmotos.pages

import androidx.compose.runtime.*
import com.straccion.webmotos.components.BackToTopButton
import com.straccion.webmotos.components.OverflowMenu
import com.straccion.webmotos.sections.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column

@Page
@Composable
fun HomePage() {
    var menuOpened by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            MainSection(onMenuClicked = {
                menuOpened = true
            })
            AboutSection()
            ServiceSection()
            PortafolioSection()
            AchievementsSection()
            TestimonialSection()
            ExperienceSection()
            ContacSection()
            FooterSection()
        }
        BackToTopButton()
        if (menuOpened){
            OverflowMenu(onMenuClosed = { menuOpened = false})
        }
    }

}
