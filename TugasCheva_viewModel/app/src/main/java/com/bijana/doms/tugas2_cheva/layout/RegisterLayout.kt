package com.bijana.doms.tugas2_cheva.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bijana.doms.tugas2_cheva.R
import com.bijana.doms.tugas2_cheva.components.ButtonCustom
import com.bijana.doms.tugas2_cheva.components.CustomTextField


@Composable
fun RegisterLayout(modifier: Modifier = Modifier) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Surface {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Register",
                fontSize = 24.sp
            )
            Text(
                text = "Daftar menggunakan username, email dan password anda."
            )
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Username",
                hint = "Buat Username",
                value = username,
                onValueChange = { text ->
                    username = text
                },
                trailingIcon = null,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Username"
                    )
                }
            )
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
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Password",
                hint = "Buat Password",
                value = password,
                onValueChange = {
                    password = it
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password"
                    )
                },
                trailingIcon = { IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = if (passwordVisible)
                            painterResource(id = R.drawable.baseline_visibility_24)
                                    else
                            painterResource(id = R.drawable.baseline_visibility_off_24),
                        contentDescription = "Visibility"
                    )
                    }
                }
            )
            ButtonCustom(
                modifier = Modifier.fillMaxWidth(),
                text = "Register"
            )

        }
    }

}

@Preview
@Composable
private fun RegisterLayoutPrev() {
    RegisterLayout()
}