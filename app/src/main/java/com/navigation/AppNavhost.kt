package com.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cheryl.elea.screens.about.AboutScreen
import com.cheryl.elea.screens.appointment.AppointmentScreen
import com.cheryl.elea.screens.hair.HairScreen
import com.cheryl.elea.screens.home.HomeScreen
import com.cheryl.elea.screens.location.LocationScreen
import com.cheryl.elea.screens.makeup.MakeupScreen
import com.cheryl.elea.screens.massage.MassageScreen
import com.cheryl.elea.screens.nails.NailsScreen
import com.cheryl.elea.screens.splash.SplashScreen
import com.cheryl.elea.ui.screens.auth.RegisterScreen
import com.data.UserDatabase
import com.repository.UserRepository
import com.starglen.zawadimart.ui.screens.auth.LoginScreen
import com.starglen.zawadimart.ui.screens.products.AddProductScreen
import com.starglen.zawadimart.ui.screens.products.EditProductScreen
import com.cheryl.elea.ui.screens.products.ProductListScreen
import com.viewmodel.AuthViewModel
import com.viewmodel.ProductViewModel


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,
    productViewModel: ProductViewModel = viewModel(),


    ) {


    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_MAKEUP) {
            MakeupScreen(navController)
        }
        composable(ROUT_MASSAGE) {
            MassageScreen(navController)
        }
        composable(ROUT_HAIR) {
            HairScreen(navController)
        }
        composable(ROUT_NAILS) {
            NailsScreen(navController)
        }
        composable(ROUT_APPOINTMENT) {
            AppointmentScreen(navController)
        }
        composable(ROUT_LOCATION) {
            LocationScreen(navController)
        }


        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }


        // PRODUCTS
        composable(ROUT_ADD_PRODUCT) {
            AddProductScreen(navController, productViewModel)
        }

        composable(ROUT_PRODUCT_LIST) {
            ProductListScreen(navController, productViewModel)
        }


        composable(
            route = ROUT_EDIT_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                EditProductScreen(productId, navController, productViewModel)
            }
        }




    }}// end of nav host
