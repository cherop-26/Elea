package com.cheryl.elea.screens.contact



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
fun ContactScreen(navController: NavController) {
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
                    .size(200.dp)
                    .padding(bottom = 16.dp)
            )

            // App Name
            Text(
                text = "Elea Beauty Lounge",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = NavyBlue
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = " To get more info on Elea, ",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = SoftGold
            )
            Spacer(modifier = Modifier.height(20.dp))
            // Contact Info
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "  contact us on:",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SoftGold)


                            Spacer(modifier = Modifier.height(30.dp))


                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "☎ +254 712 345678",
                    fontSize = 20.sp,
                    color = NavyBlue
                )
                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "  or",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SoftGold
                )

                            Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "📨 eleabeauty@gmail.com",
                    fontSize = 20.sp,
                    color = NavyBlue
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

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
fun PreviewContactScreen() {
    ContactScreen(navController = rememberNavController())
}
