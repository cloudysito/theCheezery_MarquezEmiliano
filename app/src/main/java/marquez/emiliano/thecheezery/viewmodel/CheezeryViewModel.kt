package marquez.emiliano.thecheezery.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import marquez.emiliano.thecheezery.model.data.database.AppDatabase
import marquez.emiliano.thecheezery.model.data.database.entity.ProductEntity
import marquez.emiliano.thecheezery.model.data.database.relation.ComboWithProducts
import marquez.emiliano.thecheezery.model.data.repository.CheezeryRepository
import marquez.emiliano.thecheezery.model.domain.Product

class CheezeryViewModel(application: Application = Application()) : AndroidViewModel(application) {

    private val repository = CheezeryRepository(AppDatabase.getInstance(application))

    private val _cart = MutableStateFlow<List<Product>>(emptyList())
    val cart: StateFlow<List<Product>> = _cart.asStateFlow()

    private val _combos = MutableStateFlow<List<ComboWithProducts>>(emptyList())
    val combos: StateFlow<List<ComboWithProducts>> = _combos.asStateFlow()

    private val _dbProducts = MutableStateFlow<List<ProductEntity>>(emptyList())
    val dbProducts: StateFlow<List<ProductEntity>> = _dbProducts.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getCombosWithProducts().collect { list ->
                _combos.value = list
            }
        }
        viewModelScope.launch {
            repository.getAllProducts().collect { list ->
                _dbProducts.value = list
            }
        }
    }

    fun addToCart(product: Product) {
        _cart.value = _cart.value + product
    }

    fun removeFromCart(product: Product) {
        val updated = _cart.value.toMutableList()
        updated.remove(product)
        _cart.value = updated
    }

    fun total(): Float = _cart.value.sumOf { it.price.toDouble() }.toFloat()

    fun addCombo(name: String, price: Float, selectedProductIds: List<Int>, onComplete: () -> Unit = {}) {
        viewModelScope.launch {
            repository.addComboWithProducts(name, price, selectedProductIds)
            onComplete()
        }
    }

    fun insertProduct(name: String, price: Float, image: String? = null, description: String? = null) {
        viewModelScope.launch {
            repository.insertProduct(
                ProductEntity(
                    name = name,
                    price = price,
                    image = image,
                    description = description
                )
            )
        }
    }
}
