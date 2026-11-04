package marquez.emiliano.thecheezery.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import marquez.emiliano.thecheezery.data.Category

@Composable
fun MenuScreen(innerPadding: PaddingValues, categories: List<Category>, onCategory: (Category) -> Unit, onCart: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Menu", style = MaterialTheme.typography.headlineLarge)
        Text("What would you like today?", style = MaterialTheme.typography.bodyLarge)
        categories.forEach { Button(onClick = { onCategory(it) }, Modifier.fillMaxWidth()) { Text(it.title) } }
        OutlinedButton(onClick = onCart, Modifier.fillMaxWidth()) { Text("VIEW CART") }
    }
}
