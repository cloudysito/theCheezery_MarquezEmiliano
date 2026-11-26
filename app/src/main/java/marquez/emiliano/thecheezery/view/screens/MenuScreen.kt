package marquez.emiliano.thecheezery.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import marquez.emiliano.thecheezery.model.data.Products
import marquez.emiliano.thecheezery.model.domain.Category
import marquez.emiliano.thecheezery.ui.theme.TheCheezeryTheme

@Composable
fun MenuScreen(
    innerPadding: PaddingValues,
    categories: List<Category>,
    onCategory: (Category) -> Unit,
    onCart: () -> Unit,
    onAddCombo: () -> Unit = {}
) {
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Menu", style = MaterialTheme.typography.headlineLarge)
        Text("What would you like today?", style = MaterialTheme.typography.bodyLarge)
        categories.forEach { Button(onClick = { onCategory(it) }, Modifier.fillMaxWidth()) { Text(it.title) } }
        OutlinedButton(onClick = onAddCombo, Modifier.fillMaxWidth()) { Text("ADD COMBOS") }
        OutlinedButton(onClick = onCart, Modifier.fillMaxWidth()) { Text("VIEW CART") }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    TheCheezeryTheme {
        MenuScreen(
            innerPadding = PaddingValues(0.dp),
            categories = Products.categories,
            onCategory = {},
            onCart = {},
            onAddCombo = {}
        )
    }
}
