data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val stock: Int
)

fun applyDiscount(products: List<Product>, discount: (Double) -> Double): List<Product> {
    return products.map { p ->
        p.copy(price = discount(p.price))
    }
}

fun filterProducts(products: List<Product>, condition: (Product) -> Boolean): List<Product> {
    return products.filter(condition)
}

fun main() {

    val products = listOf(
        Product("Laptop", "Electronics", 100000.0, 5),
        Product("Phone", "Electronics", 50000.0, 15),
        Product("Chair", "Furniture", 2000.0, 25),
        Product("Table", "Furniture", 3000.0, 5),
        Product("Pen", "Stationery", 50.0, 100)
    )

    val tenPercentOff: (Double) -> Double = { price -> price * 0.90 }
    val discounted = applyDiscount(products, tenPercentOff)

    println("--- Discounted Product List ---")
    for (p in discounted) {
        println("Name: ${p.name} | Category: ${p.category} | Price: ${p.price} | Stock: ${p.stock}")
    }

    val lowStock = filterProducts(discounted) { it.stock < 10 }
    println()
    println("--- Low Stock Products (<10) ---")
    for (p in lowStock) {
        println("${p.name} (${p.stock})")
    }

    val premium = filterProducts(discounted) { it.price > 1000.0 }
    println()
    println("--- Premium Products (>1000) ---")
    for (p in premium) {
        println("${p.name} (${p.price})")
    }
}