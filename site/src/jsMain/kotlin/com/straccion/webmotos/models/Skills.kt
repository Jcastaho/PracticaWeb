package com.straccion.webmotos.models

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class Skills(
    val title: String,
    val percentage: CSSSizeValue<CSSUnit.percent>
) {
    Kotlin(
        title = "Kotlin",
        percentage = 90.percent
    ),
    Compose(
        title = "Jetpack Compose",
        percentage = 90.percent
    ),
    Java(
        title = "Java",
        percentage = 80.percent
    ),
    Firebase(
        title = "Firebase",
        percentage = 80.percent
    ),
    Sqlserver(
        title = "SQL Server",
        percentage = 75.percent
    ),
    MvvmClean(
        title = "MVVM y Clean Architecture",
        percentage = 85.percent
    ),
    Git(
        title = "GitHub",
        percentage = 75.percent
    ),

}