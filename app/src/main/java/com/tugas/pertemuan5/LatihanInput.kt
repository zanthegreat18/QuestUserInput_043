package com.tugas.pertemuan5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview (showBackground = true)
@Composable
fun LatihanInput (modifier : Modifier = Modifier){
    var nama by remember { mutableStateOf (value = "") }
    var email by remember { mutableStateOf (value = "") }
    var noTelepon by remember { mutableStateOf (value = "") }
    var alamat by remember { mutableStateOf (value = "") }
    var memilihJK by remember { mutableStateOf (value = "") }

    var namasy by remember { mutableStateOf (value = "") }
    var emailsy by remember { mutableStateOf (value = "") }
    var noTeleponsy by remember { mutableStateOf (value = "") }
    var alamatsy by remember { mutableStateOf (value = "") }
    var memilihJKsy by remember { mutableStateOf (value = "") }

    val listJk= listOf("laki-laki","perempuan")

    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Biodata",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier .padding(5.dp))
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama")},
            placeholder = { Text("Masukan Nama Anda")}
        )

        Row {
            listJk.forEach {item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = memilihJK == item,
                        onClick = {
                            memilihJK = item
                        }
                    )
                    Text(item)
                }
            }
        }
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("Email")},
            placeholder = { Text("Masukan Email Anda")}
        )
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = noTelepon,
            onValueChange = {noTelepon = it},
            label = { Text("Nomer Telepon")},
            placeholder = { Text("Masukan Nomer Telepon Anda")}
        )
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat")},
            placeholder = { Text("Masukan Alamat Anda")}
        )

        Button (onClick = {
            namasy = nama
            emailsy = email
            noTeleponsy = noTelepon
            alamatsy = alamat
            memilihJKsy = memilihJK
        })
        {
            Text("Submit")
        }

        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .fillMaxWidth()

        ){
            DetailSurat(judul = "Nama", isinya = namasy)
            DetailSurat(judul = "Email", isinya = emailsy)
            DetailSurat(judul = "No Telepon", isinya = noTeleponsy)
            DetailSurat(judul = "Alamat", isinya = alamatsy)
        }
    }
}

@Composable
fun DetailSurat(
    judul:String, isinya : String
) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 2.dp)
        ) {
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = isinya,
                modifier = Modifier.weight(2f))
        }
    }
}
