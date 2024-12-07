package com.straccion.webmotos.sections

import androidx.compose.runtime.*
import com.straccion.webmotos.components.ActievementCard
import com.straccion.webmotos.models.Achievements
import com.straccion.webmotos.models.Section
import com.straccion.webmotos.models.Theme
import com.straccion.webmotos.utils.Constants.SECTION_WIDTH
import com.straccion.webmotos.utils.ObserveViewportEntered
import com.straccion.webmotos.utils.animateNumbers
import com.straccion.webmotos.utils.animateNumbers2
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.px

@Composable
fun AchievementsSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .id(Section.Archievements.id)
            .fillMaxWidth()
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 80.px)
            .backgroundColor(Theme.LightGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        AchievementsContent(breakpoint = breakpoint)
    }
}

@Composable
fun AchievementsContent(breakpoint: Breakpoint) {
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedNumbers = remember { mutableStateListOf(0,0,0,0) }

    ObserveViewportEntered(
        sectionId = Section.Archievements.id,
        distanceFromTop = 750.0,
        onViewportEntered = {
            viewportEntered = true
            Achievements.values().forEach { achievements ->
                scope.launch {
                    animateNumbers2(
                        number = achievements.number,
                        onUpdate = {
                            animatedNumbers[achievements.ordinal] = it
                        }
                    )
                }
            }
        }
    )

    SimpleGrid(numColumns = numColumns(base = 1, md = 2, lg = 4)) {
        Achievements.values().forEach { achievements ->
            ActievementCard(
                modifier = Modifier.margin(
                    right = if (achievements == Achievements.Members) 0.px
                    else {
                        if (breakpoint > Breakpoint.SM) 40.px else 0.px
                    },
                    bottom = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                ),
                animatedNumber = if (viewportEntered) animatedNumbers[achievements.ordinal] else 0,
                achievements = achievements
            )
        }
    }
}