package com.example.ssmotos.ui.theme

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ssmotos.R


@Composable
fun TelaLogin(
    espacoDasBarras:PaddingValues
) {


    var nome by remember { mutableStateOf("") }
    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var cadastrar by remember { mutableStateOf(false) }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(espacoDasBarras)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
        )
        {

        }



        if (cadastrar) {
            Spacer(modifier = Modifier.size(20.dp))

            CampodeTexto(
                value = nome,
                onValueChange = { nome = it },
                idTexto = R.string.nome
            )
        }


        Spacer(modifier = Modifier.size(20.dp))
        CampodeTexto(

            value = login,
            onValueChange = { login = it },
            idTexto = R.string.login,
        )
        Spacer(modifier = Modifier.size(20.dp))

        CampodeTexto(

            value = senha,
            onValueChange = { senha = it },
            idTexto = R.string.senha
        )
        if (cadastrar) {
            Spacer(modifier = Modifier.size(20.dp))

            CampodeTexto(
                value = confirmarSenha,
                onValueChange = { confirmarSenha = it },
                idTexto = R.string.confirmarSenha
            )
        }
        if (!cadastrar)
            Text(text = "Cadastrar conta",
                modifier = Modifier.clickable { cadastrar = !cadastrar })
        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = { cadastrar = false }
        ) {
            Text(
                text =
                if (cadastrar)
                    "cadastrar"
                else
                    "entrar"
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampodeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    idTexto: Int
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(idTexto)
            )
        }
    )
}