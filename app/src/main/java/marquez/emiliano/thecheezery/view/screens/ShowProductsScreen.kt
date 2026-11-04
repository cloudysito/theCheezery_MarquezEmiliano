package marquez.emiliano.thecheezery.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import marquez.emiliano.thecheezery.data.Category
import marquez.emiliano.thecheezery.domain.Product
import marquez.emiliano.thecheezery.ui.theme.LessPurple
import marquez.emiliano.thecheezery.viewmodel.CheezeryViewModel

@Composable
fun ShowProductsScreen(innerPadding: PaddingValues, category: Category, viewModel: CheezeryViewModel, onBack: () -> Unit, onCart: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(onClick = onBack) { Text("‹") }
            Text(category.title, style = MaterialTheme.typography.headlineLarge)
            TextButton(onClick = onCart) { Text("CART") }
        }
        LazyColumn {
            items(category.products) { ProductCard(it) { viewModel.addToCart(it) } }
        }
    }
}

@Composable
private fun ProductCard(product: Product, onAdd: () -> Unit) {
    Card(Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
        Row(Modifier.padding(12.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Image(painterResource(product.image), product.name, Modifier.size(90.dp))
            Column(Modifier.weight(1f)) {
                Text(product.name, color = LessPurple, style = MaterialTheme.typography.bodyLarge)
                Text("$${"%.2f".format(product.price)}")
                Button(onClick = onAdd) { Text("ADD") }
            }
        }
    }
}
