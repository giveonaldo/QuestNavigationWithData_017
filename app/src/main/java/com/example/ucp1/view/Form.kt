package com.example.ucp1


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulir(
    pilihanJK: List<String>,
    onSubmitBtnClick: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {

    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    val listData: MutableList<String> = mutableListOf(txtNama, txtGender, txtAlamat)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name), color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.secondary),
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding).fillMaxWidth().height(500.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = txtNama,
                onValueChange = { newText ->
                    txtNama = newText
                },
                label = { Text("Nama") },
                modifier = Modifier.padding(bottom = 15.dp)
            )

            OutlinedTextField(
                value = txtAlamat,
                onValueChange = { newText ->
                    txtAlamat = newText
                },
                label = { Text(stringResource(R.string.text_field_tag)) },
                placeholder = { Text(stringResource(R.string.text_field)) }
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                pilihanJK.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = (txtGender == item),
                        onClick = {txtGender = item}
                    ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (txtGender == item),
                            onClick = {txtGender = item}
                        )
                        Text(
                            text = item
                        )
                    }
                }
            }

            FilledTonalButton(
                onClick = {onSubmitBtnClick(listData)},
                modifier = Modifier.padding(top = 10.dp, end = 20.dp).align(Alignment.End),
            ) {
                Text(stringResource(R.string.btn_submit))
            }
        }

    }
}