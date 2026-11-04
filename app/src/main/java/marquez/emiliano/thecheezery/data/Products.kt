package marquez.emiliano.thecheezery.data

import marquez.emiliano.thecheezery.R
import marquez.emiliano.thecheezery.domain.Product

data class Category(val title: String, val products: List<Product>)

object Products {
    val categories = listOf(
        Category("Hot Drinks", listOf(
            Product("Latte", 6f, R.drawable.latte, "Coffee drink made with espresso and steamed milk"),
            Product("Hot chocolate", 5f, R.drawable.hotchocolate, "Heated drink topped with marshmallows"),
            Product("Espresso", 4f, R.drawable.espresso, "Full-flavored, concentrated coffee"),
            Product("Chai Latte", 6f, R.drawable.chailatte, "Spiced tea concentrate with milk"),
            Product("Cappuccino", 7f, R.drawable.capuccino, "Espresso-based coffee with steamed foam"),
            Product("American coffee", 2f, R.drawable.americano, "Espresso with hot water")
        )),
        Category("Cold Drinks", listOf(
            Product("Caramel Frap", 5f, R.drawable.caramel_frap, "Coffee, milk, ice and buttery caramel sauce"),
            Product("Chocolate Frap", 6f, R.drawable.chocolate_frap, "Mocha sauce, chocolate chips, milk and ice"),
            Product("Cold Brew", 3f, R.drawable.coldbrew, "Coffee steeped in room temperature water"),
            Product("Matcha Latte", 4f, R.drawable.matcha, "Matcha green tea powder with creamy milk"),
            Product("Oreo Milkshake", 7f, R.drawable.oreomilkshake, "Chocolate ice cream and Oreo cookies"),
            Product("Peanut Milkshake", 7f, R.drawable.peanutmilkshake, "Vanilla ice cream, peanut butter and chocolate")
        )),
        Category("Salties", listOf(
            Product("Chicken crepes", 6f, R.drawable.chickencrepes, "Crepes stuffed with Alfredo chicken and spinach"),
            Product("Club Sandwich", 5f, R.drawable.clubsandwich, "Delicious sandwich served with french fries"),
            Product("Panini", 4f, R.drawable.ic_panini, "Italian bread served warm"),
            Product("Philly cheese steak", 6f, R.drawable.phillycheesesteak, "Grilled onions, peppers, mushrooms and Provolone"),
            Product("Nachos", 7f, R.drawable.nachos, "Tortilla chips with beef and melted cheddar")
        )),
        Category("Sweets", listOf(
            Product("Blueberry cake", 6f, R.drawable.blueberrycake, "Vanilla cake with cheese topping and blueberries"),
            Product("Chocolate cupcake", 3f, R.drawable.chocolatecupcake, "Chocolate cupcake with buttercream and cherries"),
            Product("Lemon tartalette", 4f, R.drawable.lemontartalette, "Pastry shell with lemon flavored filling"),
            Product("Red Velvet cake", 6f, R.drawable.redvelvetcake, "Moist cake with cream cheese frosting"),
            Product("Cherry cheesecake", 7f, R.drawable.strawberrycheesecake, "Creamy cheesecake topped with cherries"),
            Product("Tiramisu", 6f, R.drawable.tiramisu, "Coffee-flavored Italian dessert")
        ))
    )
}
