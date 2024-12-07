package com.straccion.webmotos.models

import com.straccion.webmotos.utils.Res

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Res.Image.portfolio1,
        title = "Mi Moto ideal (Kotlin)",
        description = "Mi Moto ideal realizada en Kotlin Jetpack Compose"
    ),
    Two(
        image = Res.Image.portfolio2,
        title = "Mi Moto ideal (Java)",
        description = "Mi Moto ideal realizada en Java"
    ),
    Three(
        image = Res.Image.portfolio3,
        title = "ej3",
        description = "ej3"
    ),
    Four(
        image = Res.Image.portfolio4,
        title = "ej4",
        description = "ej4"
    ),
    Five(
        image = Res.Image.portfolio5,
        title = "ej5",
        description = "ej5"
    ),
}