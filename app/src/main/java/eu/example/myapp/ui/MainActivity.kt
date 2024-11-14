// MainActivity.kt
package eu.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import androidx.navigation.compose.*
import eu.example.myapp.ui.*
import eu.example.myapp.ui.screens.Grid

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            val title = when (currentRoute) {
                "list" -> "Beranda "
                "grid" -> "List Camera"
                "about" -> "About Me"
                "detail/{itemId}" -> "Detail"
                else -> ""
            }
            TopAppBar(navController = navController, title = title)
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("list") { HomeScreen(navController) }
            composable("grid") { Grid(navController) }
            composable("about") { AboutScreen() }
            composable("detail/{itemId}") { backStackEntry ->
                val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()
                itemId?.let { DetailScreen(navController, it) }
            }
        }
    }
    @Composable
    fun HomeScreen(navController: NavController) {
        Text("Home Screen") // Tambahkan konten sederhana untuk memastikan layar dipanggil
    }

}

