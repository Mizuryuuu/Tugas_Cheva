package com.bijana.doms.tugas2_cheva.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCustom(
    modifier: Modifier = Modifier,
    text: String
) {
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun PreviewButton() {
    Surface {
        ButtonCustom(text = "Click Me!");
    }
}