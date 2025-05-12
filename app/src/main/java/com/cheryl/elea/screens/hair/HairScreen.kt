package com.cheryl.elea.screens.hair

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
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
fun HairScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val hairServices = listOf(
        HairService("Haircut", "Precision haircuts tailored to your style.", R.drawable.hairbck2),
        HairService("Hair Coloring", "Vibrant color treatments and highlights.", R.drawable.hairbck2),
        HairService("Hair Styling", "Elegant styles for special occasions.", R.drawable.hairbck2),
        HairService("Keratin Treatment", "Smooth and straighten your hair.", R.drawable.hairbck2),
        HairService("Hair Extensions", "Add length and volume.", R.drawable.hairbck2),
        HairService("Scalp Treatment", "Nourish and revitalize your scalp.", R.drawable.hairbck2),
        HairService("Hair Spa", "Relaxing treatment for healthy hair.", R.drawable.hairbck2),
        HairService("Blow Dry", "Quick and flawless blowouts.", R.drawable.hairbck2),
        HairService("Braiding", "Stylish and protective hair braids.", R.drawable.hairbck2),
        HairService("Up do", "Elegant up dos for events and weddings.", R.drawable.hairbck2)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hair Services", color = nude) },
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
                    icon = { Icon(Icons.Default.Info, contentDescription = "Home",tint = navy) },
                    label = { Text("About") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_ABOUT)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Favorites",tint = navy) },
                    label = { Text("Available Experts") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1

                        navController.navigate(ROUT_PRODUCT_LIST)
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
            hairServices.forEach { service ->
                HairServiceCard(service)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun HairServiceCard(service: HairService) {
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



data class HairService(val title: String, val description: String, val imageRes: Int)

@Preview(showBackground = true)
@Composable
fun HairScreenPreview() {
    HairScreen(navController = rememberNavController())
}
