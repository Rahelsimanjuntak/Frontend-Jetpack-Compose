package eu.example.myapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import eu.example.myapp.data.Brand
import eu.example.myapp.data.DummyData

@Composable
fun Grid(navController: NavHostController) {
    val cameralist = DummyData.cameralist

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        items(cameralist) { cameraItem ->
            CameraGridItem(cameraItem)  // Ubah nama fungsi di sini
        }
    }
}

@Composable
fun CameraGridItem(camera: Brand) {  // Ubah nama fungsi di sini
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = camera.photoProduct),
            contentDescription = camera.name,
            modifier = Modifier
                .size(120.dp) // Set size untuk image
        )
        Text(
            text = camera.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = "Rp ${camera.price}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}
