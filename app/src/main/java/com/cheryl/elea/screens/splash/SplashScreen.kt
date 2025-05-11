package com.cheryl.elea.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.navigation.ROUT_HOME
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.cheryl.elea.R
import com.navigation.ROUT_LOGIN


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){

    //Navigation

    val coroutine = rememberCoroutineScope()
    coroutine.launch {
        delay(8000)
        navController.navigate(ROUT_LOGIN)
    }



    //End of Navigation

    Column(modifier = Modifier.fillMaxSize() .paint(painter = painterResource(R.drawable.splash), contentScale = ContentScale.FillBounds)
        ) {




              }



    } // end of column










@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}