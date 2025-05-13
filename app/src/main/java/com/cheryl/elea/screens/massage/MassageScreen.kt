@file:OptIn(ExperimentalMaterial3Api::class)

package com.cheryl.elea.screens.massage


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
fun MassageScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val massageServices = listOf(
        MassageService("Swedish Massage", "Gentle, relaxing full-body massage to reduce tension.", R.drawable.massagebck),
        MassageService("Deep Tissue Massage", "Targets deeper layers of muscles for chronic tension relief.", R.drawable.massagebck),
        MassageService("Hot Stone Massage", "Uses heated stones to relax and ease sore muscles.", R.drawable.massagebck),
        MassageService("Aromatherapy Massage", "Combines massage with essential oils for stress relief.", R.drawable.massagebck),
        MassageService("Thai Massage", "Stretching and compression techniques to improve flexibility.", R.drawable.massagebck),
        MassageService("Sports Massage", "Focuses on athletic injuries and performance recovery.", R.drawable.massagebck),
        MassageService("Prenatal Massage", "Gentle massage designed for pregnant women.", R.drawable.massagebck),
        MassageService("Reflexology", "Applies pressure to specific foot zones to affect body organs.", R.drawable.massagebck),
        MassageService("Shiatsu Massage", "Japanese massage using finger pressure on energy lines.", R.drawable.massagebck),
        MassageService("Couples Massage", "Side-by-side massage for two people in the same room.", R.drawable.massagebck)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Massage Services", color = nude) },
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
            massageServices.forEach { service ->
                MassageServiceCard(service)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun MassageServiceCard(service: MassageService) {
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



data class MassageService(val title: String, val description: String, val imageRes: Int)

@Preview(showBackground = true)
@Composable
fun MassageScreenPreview() {
    MassageScreen(navController = rememberNavController())
}
