package com.cheryl.elea.ui.screens.products


import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.cheryl.elea.R
import com.cheryl.elea.screens.splash.SplashScreen
import com.cheryl.elea.ui.theme.nude
import com.viewmodel.ProductViewModel
import com.model.Product
import com.navigation.ROUT_ADD_PRODUCT
import com.navigation.ROUT_EDIT_PRODUCT
import com.navigation.ROUT_HOME
import com.navigation.ROUT_PRODUCT_LIST
import com.navigation.editProductRoute
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController: NavController, viewModel: ProductViewModel) {
    val productList by viewModel.allProducts.observeAsState(emptyList())
    var showMenu by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    val filteredProducts = productList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }
    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = { Text("Service Expert", fontSize = 20.sp, color = Color(0xFF0A1D37)) },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFFF5F5DC)),
                    actions = {
                        IconButton(onClick = { showMenu = true }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Menu", tint = Color(0xFF0A1D37))
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {


                            DropdownMenuItem(
                                text = { Text("Add Account") },
                                onClick = {
                                    navController.navigate(ROUT_ADD_PRODUCT)
                                    showMenu = false
                                }
                            )
                        }
                    }
                )
            }
        },
        bottomBar = { BottomNavigationBar1(navController) }
    ) { paddingValues ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .background(Color(0xFFFAF7F0))
        ) {


            LazyColumn {
                
                items(filteredProducts.size) { index ->
                    ProductItem(navController, filteredProducts[index], viewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ProductItem(navController: NavController, product: Product, viewModel: ProductViewModel) {
    val painter: Painter = rememberAsyncImagePainter(
        model = product.imagePath?.let { Uri.parse(it) } ?: Uri.EMPTY
    )
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                if (product.id != 0) {
                    navController.navigate(ROUT_EDIT_PRODUCT)
                }
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFDF6EC)),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painter,
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .align(Alignment.BottomStart)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color(0xFF0A1D37).copy(alpha = 0.7f))
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 12.dp, bottom = 60.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF5F5DC)
                )
                Text(
                    text = "Price: Ksh${product.price}",
                    fontSize = 16.sp,
                    color = Color(0xFFF5F5DC)
                )
            }
            val mContext = LocalContext.current
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        onClick = {
                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                            smsIntent.data = "smsto:${product.phone}".toUri()
                            smsIntent.putExtra("sms_body", "Hello ${product.name},at the price of ${product.price}, I am would like to get the ........Service")
                            context.startActivity(smsIntent)
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFF5F5DC))
                    ) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Send,
                                contentDescription = "Message Expert"
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(text = "Message Expert")
                        }
                    }

                    IconButton(
                        onClick = {
                            val callIntent=Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:${product.phone}".toUri()
                            mContext.startActivity(callIntent)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = "Edit",
                            tint = Color(0xFFF5F5DC)
                        )

                }// end of icon 1
                    Spacer(modifier = Modifier.width(10.dp))
                    IconButton(
                        onClick = {
                            val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Edit",
                            tint = Color(0xFFF5F5DC)
                        )
                    }// of icon 2
            }
        }
    }
}}

@Composable
fun BottomNavigationBar1(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFF0A1D37),
        contentColor = Color(0xFFF5F5DC) // soft gold
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUT_HOME) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Product List") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUT_ADD_PRODUCT) },
            icon = { Icon(Icons.Default.AddCircle, contentDescription = "Add Product") },
            label = { Text("Add") }
        )
    }
}

