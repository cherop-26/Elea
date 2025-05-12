@file:OptIn(ExperimentalMaterial3Api::class)

package com.cheryl.elea.screens.makeup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
import com.navigation.ROUT_HAIR
import com.navigation.ROUT_HOME
import com.navigation.ROUT_MAKEUP
import com.navigation.ROUT_MASSAGE
import com.navigation.ROUT_NAILS

@Composable
fun MakeupScreen(navController: NavController){
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("         E L E A",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(start = 25.dp))
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_HOME) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = nude,
                    titleContentColor = navy,
                    navigationIconContentColor = navy




                )
            )
        },// End of top bar




        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {

                Column(modifier = Modifier.fillMaxSize()
                    .background(nude)
                    .verticalScroll(rememberScrollState()) // Enable to scroll

                ){


                    Box{


                        //Card 1:image
                        Card (
                            modifier = Modifier.fillMaxWidth()
                                .height(200.dp).background(nude),
                            shape = RoundedCornerShape(bottomStart = 120.dp, bottomEnd = 120.dp),
                            colors = CardDefaults.cardColors(nude)

                        ){

                            Image(
                                painter = painterResource(R.drawable.servicechoice),
                                contentDescription = "img",
                                modifier = Modifier.fillMaxSize(),


                                )


                        }// End of Card :image



                    }//end of box : continue with row
                    Spacer(modifier = Modifier.height(10.dp))




                    // start of scrollable column
                    Row (modifier = Modifier.verticalScroll(rememberScrollState())){
                        // row for services 1
                        Row(modifier = Modifier.padding(start = 10.dp, top = 1.dp)
                            .horizontalScroll(rememberScrollState())) {

                            // row 1
                            Row {
                                //Card 1:image
                                Card (
                                    modifier = Modifier.fillMaxWidth()
                                        .height(150.dp)
                                        .background(nude)
                                        .clickable{navController.navigate(ROUT_HAIR)},
                                    shape = RoundedCornerShape(bottomStart = 120.dp, bottomEnd = 120.dp, topStart = 120.dp, topEnd = 120.dp),
                                    colors = CardDefaults.cardColors(nude)

                                ){
                                    Image(
                                        painter = painterResource(R.drawable.braids),
                                        contentDescription = "img",
                                        modifier = Modifier.width(165.dp).height(280.dp),

                                        )


                                }// End of Card 1 :image

                                Spacer(modifier = Modifier.width(10.dp))

                                //Card 2:image
                                Card (
                                    modifier = Modifier.fillMaxWidth()
                                        .height(150.dp)
                                        .background(nude)
                                        .clickable{navController.navigate(ROUT_MASSAGE)},
                                    shape = RoundedCornerShape(bottomStart = 120.dp, bottomEnd = 120.dp, topStart = 120.dp, topEnd = 120.dp),
                                    colors = CardDefaults.cardColors(nude)

                                ){

                                    Image(
                                        painter = painterResource(R.drawable.sewin),
                                        contentDescription = "img",
                                        modifier = Modifier.width(165.dp).height(280.dp),

                                        )


                                }// End of Card 2 :image

                            }// row 1


                        }// row for services

                        // row for services2
                        Row(modifier = Modifier.padding(start = 10.dp, top = 1.dp)
                            .horizontalScroll(rememberScrollState())) {
                            // row 2
                            Row {
                                //Card 3:image
                                Card(
                                    modifier = Modifier.fillMaxWidth()
                                        .height(150.dp)
                                        .background(nude)
                                        .clickable { navController.navigate(ROUT_MAKEUP) },
                                    shape = RoundedCornerShape(
                                        bottomStart = 120.dp,
                                        bottomEnd = 120.dp,
                                        topStart = 120.dp,
                                        topEnd = 120.dp
                                    ),
                                    colors = CardDefaults.cardColors(nude)

                                ) {

                                    Image(
                                        painter = painterResource(R.drawable.locks),
                                        contentDescription = "img",
                                        modifier = Modifier.width(165.dp).height(280.dp),

                                        )


                                }// End of Card 3 :image

                                Spacer(modifier = Modifier.width(10.dp))

                                //Card 4:image
                                Card(
                                    modifier = Modifier.fillMaxWidth()
                                        .height(150.dp)
                                        .background(nude)
                                        .clickable { navController.navigate(ROUT_NAILS) },
                                    shape = RoundedCornerShape(
                                        bottomStart = 120.dp,
                                        bottomEnd = 120.dp,
                                        topStart = 120.dp,
                                        topEnd = 120.dp
                                    ),
                                    colors = CardDefaults.cardColors(nude)

                                ) {

                                    Image(
                                        painter = painterResource(R.drawable.haircut),
                                        contentDescription = "img",
                                        modifier = Modifier.width(165.dp).height(280.dp),

                                        )


                                }// End of Card 2 :image

                            }// row 2
                        }


                    }// end of scrollable column






//here

                }// end of Column of contents
            }// End of column
        }
    ) //End of scaffold




} // end of function


@Preview(showBackground = true)
@Composable
fun MakeupScreenPreview(){
    MakeupScreen(rememberNavController())
}