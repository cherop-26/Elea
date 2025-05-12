package com.cheryl.elea.screens.makeup


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cheryl.elea.R
import com.cheryl.elea.ui.theme.navy
import com.cheryl.elea.ui.theme.nude
import com.navigation.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakeupScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val makeupServices = listOf(
        MakeupService("Bridal Makeup", "Full-face, long-lasting makeup tailored for weddings.", R.drawable.makeupbck),
        MakeupService("Party Glam", "Bold, glamorous look for special occasions and events.", R.drawable.makeupbck),
        MakeupService("Natural Look", "Light makeup that enhances your natural beauty.", R.drawable.makeupbck),
        MakeupService("Evening Makeup", "Smoky eyes and contoured features for night outings.", R.drawable.makeupbck),
        MakeupService("Photoshoot Makeup", "Camera-ready makeup with flawless coverage and finish.", R.drawable.makeupbck),
        MakeupService("Editorial Makeup", "Creative and artistic makeup for fashion shoots.", R.drawable.makeupbck),
        MakeupService("Airbrush Makeup", "Flawless, lightweight foundation applied via airbrush.", R.drawable.makeupbck),
        MakeupService("HD Makeup", "High-definition makeup for close-up and video shoots.", R.drawable.makeupbck),
        MakeupService("Prom Makeup", "Trendy and vibrant look perfect for prom nights.", R.drawable.makeupbck),
        MakeupService("Makeup Consultation", "Personalized advice and testing of makeup products.", R.drawable.makeupbck)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Makeup Services", color = nude) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = nude)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = navy)
            )
        },
        bottomBar = {

            NavigationBar(
                containerColor = Color.White
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home",tint = navy) },
                    label = { Text("About") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites",tint = navy) },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1

                        navController.navigate(ROUT_HOME)
                    }
                )


            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            makeupServices.forEach { service ->
                MakeupServiceCard(service)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun MakeupServiceCard(service: MakeupService) {
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = nude),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = service.imageRes),
                contentDescription = service.title,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end=16.dp)
            )
            Column {
                Text(service.title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = navy)
                Spacer(modifier = Modifier.height(8.dp))
                Text(service.description, fontSize = 14.sp)
            }
        }
    }
}



data class MakeupService(val title: String, val description: String, val imageRes: Int)

@Preview(showBackground = true)
@Composable
fun MakeupScreenPreview() {
    MakeupScreen(navController = rememberNavController())
}
