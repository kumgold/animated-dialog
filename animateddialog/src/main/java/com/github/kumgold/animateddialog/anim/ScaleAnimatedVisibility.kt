package com.github.kumgold.animateddialog.anim

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScaleAnimatedVisibility(
    modifier: Modifier = Modifier,
    visible: Boolean,
    durationMilli: Int,
    content: @Composable() (AnimatedVisibilityScope.() -> Unit)
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = visible,
        enter = scaleIn(
            animationSpec = tween(
                durationMillis = durationMilli,
                easing = LinearEasing
            )
        ),
        exit = scaleOut(
            animationSpec = tween(
                durationMillis = durationMilli,
                easing = LinearEasing
            )
        ),
        content = content
    )
}