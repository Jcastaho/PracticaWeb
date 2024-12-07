package com.straccion.webmotos.models

import com.straccion.webmotos.utils.Res

enum class Achievements(
    val icon: String,
    val number: Int,
    val description: String
) {
    Completed(
        icon = Res.Icon.multiplatform,
        number = 5,
        description = "Proyectos Completados"
    ),
    Active(
        icon = Res.Icon.multiplatform,
        number = 2,
        description = "Proyectos Activos"
    ),
    Satisfied(
        icon = Res.Icon.multiplatform,
        number = 1,
        description = "Clientes Satisfechos"
    ),
    Members(
        icon = Res.Icon.multiplatform,
        number = 5,
        description = "Miembros de Equipo"
    ),
}