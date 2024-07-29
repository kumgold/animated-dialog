package com.github.kumgold.animateddialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.github.kumgold.animateddialog.ui.dialog.ScaleDialog
import com.github.kumgold.animateddialog.ui.dialog.SlideDialog
import com.github.kumgold.animateddialog.ui.theme.BubbleDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BubbleDialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val isShown = remember { mutableStateOf(false) }

                    TextButton(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(),
                        onClick = {
                            isShown.value = !isShown.value
                        }
                    ) {
                        Text(text = "show dialog")
                    }

                    SlideDialog(
                        dialogState = isShown,
                        title = "title",
                        description = "desciption"
                    )
                }
            }
        }
    }
}
