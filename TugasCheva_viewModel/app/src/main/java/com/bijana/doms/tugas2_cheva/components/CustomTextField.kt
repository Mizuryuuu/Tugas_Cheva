package com.bijana.doms.tugas2_cheva.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit),
    trailingIcon : @Composable (() -> Unit)?
) {
    Column (
        modifier = modifier
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge
        )
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(0.8f),
            value = value,
            onValueChange = onValueChange,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            placeholder = {
                Text(text = hint)
            }
        )
    }
}

@Preview
@Composable
private fun CustomFieldPrev() {

    var email by remember { mutableStateOf("") }

    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        label = "Email",
        hint = "Buat Email",
        value = email,
        onValueChange = { text ->
            email = text
        },
        trailingIcon = null,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "email"
            )
        }
    )
}