package com.github.kumgold.animateddialog.dialog

import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BasicDialog(
    modifier: Modifier = Modifier,
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
    buttonTextStyle: TextStyle = LocalTextStyle.current
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .wrapContentHeight()
                .background(
                    color = containerColor,
                    shape = containerShape
                )
                .padding(16.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                textAlign = TextAlign.Center,
                style = titleTextStyle
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = description,
                style = descriptionTextStyle
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    onClick = {
                        onClickNegative()
                    }
                ) {
                    Text(
                        text = negativeText,
                        style = buttonTextStyle
                    )
                }
                TextButton(
                    onClick = {
                        onClickPositive()
                    }
                ) {
                    Text(
                        text = positiveText,
                        style = buttonTextStyle
                    )
                }
            }
        }
    }
}