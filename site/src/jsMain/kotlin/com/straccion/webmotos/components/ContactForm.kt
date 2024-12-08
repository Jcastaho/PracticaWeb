package com.straccion.webmotos.components

import androidx.compose.runtime.*
import com.straccion.webmotos.models.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm(breakpoint: Breakpoint) {
    var isHovered by remember { mutableStateOf(false) }
    Form(
        action = "https://formspree.io/f/xovqzvbz",
        attrs = Modifier
            .attrsModifier {
                attr("method", "POST")
            }
            .toAttrs()
    ) {
        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputName"
        ) {
            Text("Nombre")
        }
        Input(
            type = InputType.Text,
            attrs = Modifier
                .id("inputName")
                .classNames("form-control")
                .margin(bottom = 10.px)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .width(
                    if (breakpoint >= Breakpoint.MD) 500.px
                    else 300.px
                )
                .attrsModifier {
                    attr("placeholder", "Nombre Completo")
                    attr("name", "name")
                    attr("required", "true")
                    style {
                        property("border", "1px solid ${Theme.LightGray.rgb}")
                        property("background-color", Theme.LighterGray.rgb)
                    }
                    attr("onfocus", "this.style.border='2px solid ${Theme.Primary.rgb}'")
                    attr("onblur", "this.style.border='1px solid ${Theme.LightGray.rgb}'")
                }
                .backgroundColor(Theme.LighterGray.rgb)
                .toAttrs()
        )


        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputEmail"
        ) {
            Text("Correo")
        }
        Input(
            type = InputType.Email,
            attrs = Modifier
                .id("inputEmail")
                .classNames("form-control")
                .margin(bottom = 10.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 500.px
                    else 300.px
                )
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Correo Electrónico")
                    attr("name", "email")
                    attr("required", "true")
                    style {
                        property("border", "1px solid ${Theme.LightGray.rgb}")
                        property("background-color", Theme.LighterGray.rgb)
                    }
                    attr("onfocus", "this.style.border='2px solid ${Theme.Primary.rgb}'")
                    attr("onblur", "this.style.border='1px solid ${Theme.LightGray.rgb}'")
                }
                .backgroundColor(Theme.LighterGray.rgb)
                .toAttrs()
        )


        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputMessage"
        ) {
            Text("Mensaje")
        }
        TextArea(
            attrs = Modifier
                .id("inputMessage")
                .classNames("form-control")
                .margin(bottom = 20.px)
                .height(150.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 500.px
                    else 300.px
                )
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Mensaje a Enviar...")
                    attr("name", "message")
                    attr("required", "true")
                    style {
                        property("border", "1px solid ${Theme.LightGray.rgb}")
                        property("background-color", Theme.LighterGray.rgb)
                    }
                    attr("onfocus", "this.style.border='2px solid ${Theme.Primary.rgb}'")
                    attr("onblur", "this.style.border='1px solid ${Theme.LightGray.rgb}'")
                }
                .backgroundColor(Theme.LighterGray.rgb)
                .toAttrs()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                attrs = Modifier
                    .width(if (isHovered) 120.px else 100.px)
                    .height(40.px)
                    .borderRadius(r = 5.px)
                    .border(width = 0.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .styleModifier {
                        transition(
                            Transition.of("width", 300.ms),
                            Transition.of("height", 300.ms) // Si necesitas animar también el alto
                        )
                    }
                    .onMouseEnter { isHovered = true }
                    .onMouseLeave { isHovered = false }
                    .toAttrs()
            ) {
                Text("Enviar")
            }
        }

    }
}