package marquez.emiliano.thecheezery.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import marquez.emiliano.thecheezery.model.data.Products
import marquez.emiliano.thecheezery.model.domain.Category
import marquez.emiliano.thecheezery.viewmodel.CheezeryViewModel
import marquez.emiliano.thecheezery.view.screens.AddComboScreen
import marquez.emiliano.thecheezery.view.screens.CartScreen
import marquez.emiliano.thecheezery.view.screens.LoginScreen
import marquez.emiliano.thecheezery.view.screens.MenuScreen
import marquez.emiliano.thecheezery.view.screens.ShowProductsScreen
import marquez.emiliano.thecheezery.view.screens.WelcomeScreen

@Composable
fun TheCheezeryNavHost(innerPadding: PaddingValues, viewModel: CheezeryViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Welcome) {
        composable<Welcome> {
            WelcomeScreen(innerPadding) { navController.navigate(Login) }
        }
        composable<Login> {
            LoginScreen(innerPadding) { navController.navigate(Menu) { popUpTo(Login) { inclusive = true } } }
        }
        composable<Menu> {
            MenuScreen(
                innerPadding = innerPadding,
                categories = Products.categories,
                onCategory = { category ->
                    SelectedCategory.value = category
                    navController.navigate(Products)
                },
                onCart = { navController.navigate(Cart) },
                onAddCombo = { navController.navigate(AddCombo) }
            )
        }
        composable<Products> {
            ShowProductsScreen(innerPadding, SelectedCategory.value, viewModel,
                onBack = { navController.popBackStack() },
                onCart = { navController.navigate(Cart) })
        }
        composable<Cart> {
            CartScreen(innerPadding, viewModel) { navController.popBackStack() }
        }
        composable<AddCombo> {
            AddComboScreen(innerPadding, viewModel) { navController.popBackStack() }
        }
    }
}

object SelectedCategory {
    var value: Category = Products.categories.first()
}
