package com.cheryl.elea.screens.about


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cheryl.elea.R
import com.navigation.ROUT_HOME

val NavyBlue = Color(0xFF1B263B)
val SoftGold = Color(0xFFCBA135)
val Beige = Color(0xFFF5F5DC)

@Composable
fun AboutScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Beige
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.splash), // Replace with your logo
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )

            // App Name
            Text(
                text = "Elea Beauty Lounge",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = NavyBlue
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Description Card
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "About Us",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = SoftGold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "At Elea , we believe in enhancing your natural beauty through luxurious experiences. Our team of professionals is passionate about delivering high-quality hair, nail, makeup, and massage services tailored to your needs.",
                        fontSize = 16.sp,
                        color = NavyBlue,
                        lineHeight = 22.sp
                    )
                }
            }

            // Contact Info
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Contact Us",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = SoftGold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "📍 Nairobi, Kenya",
                    fontSize = 14.sp,
                    color = NavyBlue
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "☎ +254 712 345678",
                    fontSize = 14.sp,
                    color = NavyBlue
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "📨 eleabeauty@gmail.com",
                    fontSize = 14.sp,
                    color = NavyBlue
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate(ROUT_HOME) },
                colors = ButtonDefaults.buttonColors(containerColor = NavyBlue)
            ) {
                Text("Go to Home", color = Beige)
            }
        }
    }// end of fun about
}

@Preview(showBackground = true)
@Composable
fun PreviewAboutScreen() {
    AboutScreen(navController = rememberNavController())
}
