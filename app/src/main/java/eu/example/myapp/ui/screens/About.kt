// About.kt
package eu.example.myapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import eu.example.myapp.R

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.me ),
            contentDescription = "Your Photo",
            modifier = Modifier.size(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nama: Rahel Simanjuntak")
        Text(text = "Universitas: Politeknik Negeri Batam")
        Text(text = "Jurusan: Teknik Informatika")
        Text(text = "Program Studpen: Android Mobile Development")
        Text(text = "Sesi: Pagi")
        Text(text = "Personal Mentor: Reza Kurniawan")
    }
}
