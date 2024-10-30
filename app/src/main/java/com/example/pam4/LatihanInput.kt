package com.example.pam4

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihJk by remember { mutableStateOf("") }

    var namaSave by remember { mutableStateOf("") }
    var emailSave by remember { mutableStateOf("") }
    var noTelponSave by remember { mutableStateOf("") }
    var alamatSave by remember { mutableStateOf("") }
    var memilihJkSave by remember { mutableStateOf("") }

    val listJK = listOf("Laki-Laki","Perempuan")
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Biodata",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold )

        Spacer(Modifier.padding(16.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama")},
            placeholder = { Text("Masukkan Nama Anda")}
        )

        Row {
            listJK.forEach { item ->
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RadioButton(
                        selected = memilihJk == item,
                        onClick = {
                            memilihJk = item
                        }
                    )
                    Text(item)
                }
            }
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("Email")},
            placeholder = { Text("Masukkan Email Anda")}
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = noTelpon,
            onValueChange = {noTelpon = it},
            label = { Text("No Telephone")},
            placeholder = { Text("Masukkan No Telephone Anda")}
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat")},
            placeholder = { Text("Masukkan Alamat Anda")}
        )

        Button (onClick = {
            namaSave = nama
            emailSave = email
            noTelponSave = noTelpon
            alamatSave = alamat
            memilihJkSave = memilihJk
        }) {
            Text("Submit")
        }

        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.Yellow),
            modifier = Modifier.fillMaxWidth()
        )
        {
            DetailsSurat(judul = "Nama", Isinya = namaSave)
            DetailsSurat(judul = "Email", Isinya = emailSave)
            DetailsSurat(judul = "No Telephone", Isinya = noTelponSave)
            DetailsSurat(judul = "Alamat", Isinya = alamatSave)
            DetailsSurat(judul = "Jenis Kelamin", Isinya = memilihJkSave)
        }
    }
}

@Composable
// untuk memanggil di elevated card
fun DetailsSurat(judul: String, Isinya: String){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = " : ",
                modifier = Modifier.weight(0.2f))
            Text(text = Isinya,
                modifier = Modifier.weight(2f))
        }
}
