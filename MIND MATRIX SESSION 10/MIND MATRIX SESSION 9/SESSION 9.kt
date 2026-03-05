data class Item(
    val name: String,
    val category: String,
    val quantity: Int
)

fun printInventory(items: List<Item>) {
    if (items.isEmpty()) {
        println("No items found")
        return
    }
    for (item in items) {
        println("Name: ${item.name} | Category: ${item.category} | Qty: ${item.quantity}")
    }
}

fun <T> filterList(list: List<T>, condition: (T) -> Boolean): List<T> {
    return list.filter(condition)
}

fun main() {

    val items = listOf(
        Item("Laptop", "Electronics", 12),
        Item("Keyboard", "Electronics", 5),
        Item("Chair", "Furniture", 20),
        Item("Table", "Furniture", 8),
        Item("Notebook", "Stationery", 50),
        Item("Pen", "Stationery", 6)
    )

    println("--- Full Inventory ---")
    printInventory(items)

    val lowStock = filterList(items) { it.quantity < 10 }
    println()
    println("--- Low Stock (<10) ---")
    printInventory(lowStock)

    val electronics = filterList(items) { it.category == "Electronics" }
    println()
    println("--- Electronics Category ---")
    printInventory(electronics)

    val totals = items.groupBy { it.category }
        .mapValues { entry -> entry.value.map { it.quantity }.sum() }

    println()
    println("--- Total Quantity per Category ---")
    for ((category, total) in totals) {
        println("$category: $total")
    }
}