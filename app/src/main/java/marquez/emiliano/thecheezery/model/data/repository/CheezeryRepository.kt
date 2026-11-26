package marquez.emiliano.thecheezery.model.data.repository

import kotlinx.coroutines.flow.Flow
import marquez.emiliano.thecheezery.model.data.database.AppDatabase
import marquez.emiliano.thecheezery.model.data.database.entity.ComboEntity
import marquez.emiliano.thecheezery.model.data.database.entity.ProductComboEntity
import marquez.emiliano.thecheezery.model.data.database.entity.ProductEntity
import marquez.emiliano.thecheezery.model.data.database.relation.ComboWithProducts

class CheezeryRepository(private val database: AppDatabase) {

    private val productDao = database.productDao()
    private val comboDao = database.comboDao()
    private val productComboDao = database.productsComboDao()

    suspend fun insertProduct(product: ProductEntity): Long {
        return productDao.insertProduct(product)
    }

    suspend fun insertProducts(products: List<ProductEntity>): List<Long> {
        return productDao.insertProducts(products)
    }

    fun getAllProducts(): Flow<List<ProductEntity>> {
        return productDao.getAllProducts()
    }

    suspend fun getProductById(id: Int): ProductEntity? {
        return productDao.getProductById(id)
    }

    fun searchProducts(name: String): Flow<List<ProductEntity>> {
        return productDao.searchProducts(name)
    }

    suspend fun insertCombo(combo: ComboEntity): Long {
        return comboDao.insertCombo(combo)
    }

    fun getCombosWithProducts(): Flow<List<ComboWithProducts>> {
        return comboDao.getCombosWithProducts()
    }

    suspend fun insertProductCombo(productCombo: ProductComboEntity): Long {
        return productComboDao.insertProductCombo(productCombo)
    }

    suspend fun addComboWithProducts(name: String, price: Float, productIds: List<Int>): Long {
        val comboId = comboDao.insertCombo(ComboEntity(name = name, price = price))
        for (productId in productIds) {
            productComboDao.insertProductCombo(
                ProductComboEntity(idProduct = productId, idCombo = comboId.toInt())
            )
        }
        return comboId
    }
}
