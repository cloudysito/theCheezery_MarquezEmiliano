package marquez.emiliano.thecheezery.model.domain

import androidx.annotation.DrawableRes

data class Product(
    val name: String,
    val price: Float,
    @DrawableRes val image: Int,
    val description: String
)
