package marquez.emiliano.thecheezery.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import marquez.emiliano.thecheezery.ui.theme.LessPurple
import marquez.emiliano.thecheezery.viewmodel.CheezeryViewModel

@Composable
fun AddComboScreen(
    innerPadding: PaddingValues,
    viewModel: CheezeryViewModel,
    onBack: () -> Unit
) {
    var comboName by remember { mutableStateOf("") }
    var comboPrice by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    val combos by viewModel.combos.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = onBack) { Text("‹ Back") }
            Text("Add Combo", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.width(48.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = comboName,
            onValueChange = { comboName = it },
            label = { Text("Combo Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = comboPrice,
            onValueChange = { comboPrice = it },
            label = { Text("Price ($)") },
            modifier = Modifier.fillMaxWidth()
        )

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(errorMessage, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val priceFloat = comboPrice.toFloatOrNull()
                if (comboName.isNotBlank() && priceFloat != null) {
                    viewModel.addCombo(
                        name = comboName,
                        price = priceFloat,
                        selectedProductIds = emptyList()
                    ) {
                        comboName = ""
                        comboPrice = ""
                        errorMessage = ""
                    }
                } else {
                    errorMessage = "Please enter a valid name and price"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("SAVE COMBO")
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Saved Combos:", style = MaterialTheme.typography.titleMedium, color = LessPurple)
        Spacer(modifier = Modifier.height(8.dp))

        if (combos.isEmpty()) {
            Text("No combos added yet.")
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(items = combos) { comboWithProducts ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(comboWithProducts.combo.name, style = MaterialTheme.typography.bodyLarge)
                            Text("$${"%.2f".format(comboWithProducts.combo.price)}", color = LessPurple)
                        }
                    }
                }
            }
        }
    }
}
