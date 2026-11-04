package marquez.emiliano.thecheezery.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import marquez.emiliano.thecheezery.domain.Product

class CheezeryViewModel : ViewModel() {
    private val _cart = MutableStateFlow<List<Product>>(emptyList())
    val cart: StateFlow<List<Product>> = _cart

    fun addToCart(product: Product) {
        _cart.value = _cart.value + product
    }

    fun removeFromCart(product: Product) {
        val updated = _cart.value.toMutableList()
        updated.remove(product)
        _cart.value = updated
    }

    fun total(): Float = _cart.value.sumOf { it.price.toDouble() }.toFloat()
}
