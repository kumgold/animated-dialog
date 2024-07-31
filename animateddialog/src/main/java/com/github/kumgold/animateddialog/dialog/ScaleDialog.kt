package com.github.kumgold.animateddialog.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.kumgold.animateddialog.anim.ScaleAnimatedVisibility

@Composable
fun ScaleDialog(
    dialogState: MutableState<Boolean>,
    durationMilli: Int = 300,
    backgroundColor: Color = Color.Black.copy(alpha = 0.8f),
    title: String = "",
    description: String = "",
    negativeText: String = "",
    onClickNegative: () -> Unit = {},
    positiveText: String = "",
    onClickPositive: () -> Unit = {},
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    containerShape: Shape = RoundedCornerShape(8.dp),
    titleTextStyle: TextStyle = LocalTextStyle.current,
    descriptionTextStyle: TextStyle = LocalTextStyle.current,
    buttonTextStyle: TextStyle = LocalTextStyle.current,
) {
    if (dialogState.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .clickable {
                    dialogState.value = false
                }
        )
    }

    com.github.kumgold.animateddialog.anim.ScaleAnimatedVisibility(
        visible = dialogState.value,
        durationMilli = durationMilli
    ) {
        BasicDialog(
            title = title,
            description = description,
            negativeText = negativeText,
            onClickNegative = {
                dialogState.value = false
                onClickNegative()
            },
            positiveText = positiveText,
            onClickPositive = {
                dialogState.value = false
                onClickPositive()
            },
            containerColor = containerColor,
            containerShape = containerShape,
            titleTextStyle = titleTextStyle,
            descriptionTextStyle = descriptionTextStyle,
            buttonTextStyle = buttonTextStyle
        )
    }
}