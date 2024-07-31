package com.github.kumgold.animateddialog.anim

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SlideAnimatedVisibility(
    modifier: Modifier = Modifier,
    visible: Boolean,
    durationMilli: Int,
    content: @Composable() (AnimatedVisibilityScope.() -> Unit)
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = visible,
        enter = slideInVertically(
            animationSpec = tween(
                durationMillis = durationMilli,
                easing = LinearEasing
            ),
            initialOffsetY = { height -> height }
        ),
        exit = slideOutVertically(
            animationSpec = tween(
                durationMillis = durationMilli,
                easing = LinearEasing
            ),
            targetOffsetY = { height -> height }
        ),
        content = content
    )
}