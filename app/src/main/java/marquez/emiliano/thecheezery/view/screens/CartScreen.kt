package marquez.emiliano.thecheezery.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.collectAsState
import marquez.emiliano.thecheezery.model.data.Products
import marquez.emiliano.thecheezery.ui.theme.LessPurple
import marquez.emiliano.thecheezery.ui.theme.TheCheezeryTheme
import marquez.emiliano.thecheezery.viewmodel.CheezeryViewModel

@Composable
fun CartScreen(innerPadding: PaddingValues, viewModel: CheezeryViewModel, onBack: () -> Unit) {
    val cart by viewModel.cart.collectAsState()
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Your cart", style = MaterialTheme.typography.headlineLarge)
        TextButton(onClick = onBack) { Text("BACK TO MENU") }
        if (cart.isEmpty()) Text("Add some products to your order!", style = MaterialTheme.typography.bodyLarge)
        else LazyColumn(Modifier.weight(1f)) {
            items(cart) { product ->
                Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(product.name, style = MaterialTheme.typography.bodyLarge)
                    Text("$${"%.2f".format(product.price)}", color = LessPurple)
                    TextButton(onClick = { viewModel.removeFromCart(product) }) { Text("REMOVE") }
                }
            }
        }
        Text("Total: $${"%.2f".format(viewModel.total())}", style = MaterialTheme.typography.headlineMedium, color = LessPurple)
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    val sampleViewModel = remember {
        CheezeryViewModel().apply {
            Products.categories.firstOrNull()?.products?.take(2)?.forEach { addToCart(it) }
        }
    }
    TheCheezeryTheme {
        CartScreen(
            innerPadding = PaddingValues(0.dp),
            viewModel = sampleViewModel,
            onBack = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenEmptyPreview() {
    val emptyViewModel = remember { CheezeryViewModel() }
    TheCheezeryTheme {
        CartScreen(
            innerPadding = PaddingValues(0.dp),
            viewModel = emptyViewModel,
            onBack = {}
        )
    }
}
