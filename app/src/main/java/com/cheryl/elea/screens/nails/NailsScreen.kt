package com.cheryl.elea.screens.nails


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
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
fun NailsScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val NailServices = listOf(
        NailService("Classic Manicure", "Nail trimming,shaping,cuticle care and polish.", R.drawable.nailsbck3),
        NailService("Spa pedicure", "Foot soak,exfoliant, massage and nail polish.", R.drawable.nailsbck3),
        NailService("Gel Polish", "long-lasting,high-gloss gel polish cured with UV light", R.drawable.nailsbck3),
        NailService("Acrylic Full Set", "Acrylic nail extensions with custom shaping and polish.", R.drawable.nailsbck3),
        NailService("Nail Art Design", "Custom hand-painted or decal nail designs.", R.drawable.nailsbck3),
        NailService("Dip Powder Nails", "Durable, odorless powder-based color system.", R.drawable.nailsbck3),
        NailService("Nail Repair", "Fixing cracks, splits, or lifting on natural or artificial nails.", R.drawable.nailsbck3),
        NailService("Cuticle Treatment", "Conditioning and trimming of cuticles for healthy nail growth.", R.drawable.nailsbck3),

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nail Services", color = nude) },
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
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites",tint = navy) },
                    label = { Text("Available Experts") },
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
           NailServices.forEach { service ->
                NailsServiceCard(service)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun NailsServiceCard(service: NailService) {
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



data class NailService(val title: String, val description: String, val imageRes: Int)

@Preview(showBackground = true)
@Composable
fun NailsScreenPreview() {
    NailsScreen(navController = rememberNavController())
}
