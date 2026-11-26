package marquez.emiliano.thecheezery.model.domain

data class Category(
    val title: String,
    val products: List<Product> = emptyList(),
    val id: Int = 0
)
