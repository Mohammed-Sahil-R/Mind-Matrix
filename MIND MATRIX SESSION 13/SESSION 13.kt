/**
 * Superhero Directory & 30-Day Schedule — Student Template
 *
 * Task (2-3 lines):
 * Build a console program that manages a list of superheroes and simulates a 30-day reading/viewing schedule.
 * Practice data classes, collection filtering, generating schedules, and producing accessible descriptions.
 *
 * Instructions (step-by-step):
 * 1) Create a data class `Superhero` with:
 *      - name: String
 *      - alias: String
 *      - power: String
 *      - favorite: Boolean (default false)
 *      - accessibleDescription: String (text used for accessibility)
 *
 * 2) Implement `formatHero(hero: Superhero): String`
 *      - Returns a single-line formatted string: "Name (Alias) - Power [Fav]" and includes "(A11y: ...)" at the end
 *
 * 3) Implement `filterByPower(heroes: List<Superhero>, powerQuery: String): List<Superhero>`
 *      - Return heroes whose power matches powerQuery (case-insensitive contains)
 *
 * 4) Implement `getFavorites(heroes: List<Superhero>): List<Superhero>`
 *      - Return the list of heroes where favorite == true
 *
 * 5) Implement `generateSchedule(heroes: List<Superhero>, days: Int): List<String>`
 *      - Create a schedule of length `days` where each day maps to a hero.
 *      - If there are favorites, cycle through favorites; otherwise cycle through all heroes.
 *      - Each entry should be like: "Day 1: Superman (Read about flying)"
 *
 * 6) In main():
 *      - Create at least 6 superheroes (some favorites, various powers).
 *      - Print the full directory formatted.
 *      - Print heroes that match a sample power filter (e.g., "strength" or "flight").
 *      - Print only favorite heroes.
 *      - Generate and print a 30-day schedule (use generateSchedule).
 *
 * HINTS (comments only):
 * - Use `toLowerCase()` for case-insensitive matching.
 * - Use `List` indexing and modulo (%) to cycle through a small list.
 * - Keep formatHero pure (return string, do not print inside).
 *
 * Sample Output (example; follow exact formatting in instructor solution):
 *
 * --- Superhero Directory ---
 * 1. Clark Kent (Superman) - Flight [Fav] (A11y: Clark Kent, alias Superman, power Flight)
 * 2. Diana Prince (Wonder Woman) - Strength [Fav] (A11y: Diana Prince, alias Wonder Woman, power Strength)
 * ...
 *
 * --- Filter: flight ---
 * 1. Clark Kent (Superman) - Flight [Fav] (A11y: ...)
 *
 * --- Favorites ---
 * 1. Clark Kent (Superman) - Flight [Fav] (A11y: ...)
 * 2. Diana Prince (Wonder Woman) - Strength [Fav] (A11y: ...)
 *
 * --- 30-Day Schedule ---
 * Day 1: Clark Kent (Superman)
 * Day 2: Diana Prince (Wonder Woman)
 * ...
 *
 * TODOs:
 * // TODO: Define data class Superhero(...)
 * // TODO: Implement formatHero(hero: Superhero): String
 * // TODO: Implement filterByPower(heroes, powerQuery)
 * // TODO: Implement getFavorites(heroes)
 * // TODO: Implement generateSchedule(heroes, days)
 * // TODO: Implement main() building sample data and printing the sections above
 */
 
// -------------
// Student area
// -------------
data class Superhero(
    val name: String,
    val alias: String,
    val power: String,
    val favorite: Boolean = false,
    val accessibleDescription: String
)

fun formatHero(hero: Superhero): String {
    val favTag = if (hero.favorite) " [Fav]" else ""
    return "${hero.name} (${hero.alias}) - ${hero.power}$favTag (A11y: ${hero.accessibleDescription})"
}

fun filterByPower(heroes: List<Superhero>, powerQuery: String): List<Superhero> {
    val q = powerQuery.toLowerCase()
    return heroes.filter { it.power.toLowerCase().contains(q) }
}

fun getFavorites(heroes: List<Superhero>): List<Superhero> {
    return heroes.filter { it.favorite }
}

fun generateSchedule(heroes: List<Superhero>, days: Int): List<String> {
    if (heroes.isEmpty() || days <= 0) return emptyList()

    val favorites = getFavorites(heroes)
    val source = if (favorites.isNotEmpty()) favorites else heroes

    val schedule = ArrayList<String>()
    for (day in 1..days) {
        val hero = source[(day - 1) % source.size]
        schedule.add("Day $day: ${hero.name} (${hero.alias})")
    }
    return schedule
}

fun main() {

    val heroes = listOf(
        Superhero(
            name = "Clark Kent",
            alias = "Superman",
            power = "Flight",
            favorite = true,
            accessibleDescription = "Clark Kent, alias Superman, power Flight"
        ),
        Superhero(
            name = "Diana Prince",
            alias = "Wonder Woman",
            power = "Strength",
            favorite = true,
            accessibleDescription = "Diana Prince, alias Wonder Woman, power Strength"
        ),
        Superhero(
            name = "Bruce Wayne",
            alias = "Batman",
            power = "Intelligence",
            favorite = false,
            accessibleDescription = "Bruce Wayne, alias Batman, power Intelligence"
        ),
        Superhero(
            name = "Peter Parker",
            alias = "Spider-Man",
            power = "Agility",
            favorite = false,
            accessibleDescription = "Peter Parker, alias Spider-Man, power Agility"
        ),
        Superhero(
            name = "Barry Allen",
            alias = "Flash",
            power = "Speed",
            favorite = false,
            accessibleDescription = "Barry Allen, alias Flash, power Speed"
        ),
        Superhero(
            name = "Tony Stark",
            alias = "Iron Man",
            power = "Technology",
            favorite = false,
            accessibleDescription = "Tony Stark, alias Iron Man, power Technology"
        )
    )

    println("--- Superhero Directory ---")
    for ((index, hero) in heroes.withIndex()) {
        println("${index + 1}. ${formatHero(hero)}")
    }

    val filterQuery = "flight"
    val filtered = filterByPower(heroes, filterQuery)

    println()
    println("--- Filter: $filterQuery ---")
    if (filtered.isEmpty()) {
        println("No heroes found")
    } else {
        for ((index, hero) in filtered.withIndex()) {
            println("${index + 1}. ${formatHero(hero)}")
        }
    }

    val favorites = getFavorites(heroes)

    println()
    println("--- Favorites ---")
    if (favorites.isEmpty()) {
        println("No favorites found")
    } else {
        for ((index, hero) in favorites.withIndex()) {
            println("${index + 1}. ${formatHero(hero)}")
        }
    }

    println()
    println("--- 30-Day Schedule ---")
    val schedule = generateSchedule(heroes, 30)
    for (line in schedule) {
        println(line)
    }
}