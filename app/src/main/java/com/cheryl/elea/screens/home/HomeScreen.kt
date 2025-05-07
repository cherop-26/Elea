package com.cheryl.elea.screens.home


import android.R.color.black
import android.R.color.white
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.cheryl.elea.ui.theme.PurpleGrey80
import com.cheryl.elea.ui.theme.aqua
import com.cheryl.elea.ui.theme.blush
import com.cheryl.elea.ui.theme.navy
import com.cheryl.elea.ui.theme.newwhite
import com.cheryl.elea.ui.theme.nude
import com.navigation.ROUT_ABOUT
import com.navigation.ROUT_HOME


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("    Elea") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newwhite,
                    titleContentColor = navy,
                    navigationIconContentColor = navy
                )
            )
        },// End of top bar

        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Home",tint = navy) },
                    label = { Text("About") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.LocationOn, contentDescription = "Favorites",tint = navy) },
                    label = { Text("Safety") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1

                        navController.navigate(ROUT_ABOUT)
                    }


                )

            }
        },// End of bottom bar


        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {

    Column(modifier = Modifier.fillMaxSize()
        .background(aqua)
        .verticalScroll(rememberScrollState()) // Enable to scroll

    ){


        Box{
            //Card 1:aqua
            Card (
                modifier = Modifier.fillMaxWidth().height(300.dp),
                shape = RoundedCornerShape(bottomStart = 150.dp, bottomEnd = 150.dp),
                colors = CardDefaults.cardColors(Color.White)



            ){


                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "img",
                    modifier = Modifier.width(400.dp).height(200.dp).padding(start = 10.dp, top = 20.dp)
                )



            }// End of Card :blush


            //Row
            Row(modifier = Modifier.padding(start = 10.dp, top = 150.dp)
                .offset(y = 90.dp)
                .horizontalScroll(rememberScrollState())) {

                //Card 1
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(300.dp),
                    shape = RoundedCornerShape(80.dp)


                ) {


                    Column(
                        modifier = Modifier.fillMaxSize().background(nude).padding(start = 40.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,


                        ) {

                        //image 1
                        Image(
                            painter = painterResource(R.drawable.nails),
                            contentDescription = "img",
                            modifier = Modifier.size(100.dp)

                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Nails",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(start = 25.dp)

                            )
                        Spacer(modifier = Modifier.height(2.dp))
                        Image(
                            painter = painterResource(R.drawable.leaf),
                            contentDescription = "img",
                            modifier = Modifier.size(80.dp).padding(start = 30.dp)

                        )


                    }

                }
                //End of card1

                Spacer(modifier = Modifier.width(20.dp))

                //Card 2
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(300.dp),
                    shape = RoundedCornerShape(80.dp)


                ) {


                    Column(
                        modifier = Modifier.fillMaxSize().background(nude).padding(start = 50.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,


                        ) {

                        //image 2
                        Image(
                            painter = painterResource(R.drawable.hair),
                            contentDescription = "img",
                            modifier = Modifier.size(100.dp)

                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Hair",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(start = 25.dp)

                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Image(
                            painter = painterResource(R.drawable.leaf),
                            contentDescription = "img",
                            modifier = Modifier.size(80.dp).padding(start = 30.dp)

                        )


                    }

                }
                //End of card2

                Spacer(modifier = Modifier.width(20.dp))

                //Card 3
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(300.dp),
                    shape = RoundedCornerShape(80.dp)


                ) {


                    Column(
                        modifier = Modifier.fillMaxSize().background(nude).padding(start = 50.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,


                        ) {

                        //image 3
                        Image(
                            painter = painterResource(R.drawable.makeup),
                            contentDescription = "img",
                            modifier = Modifier.size(100.dp)

                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Make up",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(start = 5.dp)

                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Image(
                            painter = painterResource(R.drawable.leaf),
                            contentDescription = "img",
                            modifier = Modifier.size(80.dp).padding(start = 30.dp)

                        )


                    }

                }
                //End of card3

                Spacer(modifier = Modifier.width(20.dp))

                //Card 4
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(300.dp),
                    shape = RoundedCornerShape(80.dp)


                ) {


                    Column(
                        modifier = Modifier.fillMaxSize().background(nude).padding(start = 50.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,


                        ) {

                        //image 4
                        Image(
                            painter = painterResource(R.drawable.massage),
                            contentDescription = "img",
                            modifier = Modifier.size(100.dp)

                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Massage",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(start = 2.dp)

                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Image(
                            painter = painterResource(R.drawable.leaf),
                            contentDescription = "img",
                            modifier = Modifier.size(80.dp).padding(start = 30.dp)

                        )


                    }

                }
                //End of card4

                Spacer(modifier = Modifier.width(20.dp))





            }//end of box




        Spacer(modifier = Modifier.height(30.dp))


        }//End of row







    }// End of column


            }// here
        }
    )

    //End of scaffold






} // end of home screen


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}