abstract class Animal(val name: String) {
    abstract fun makeSound()
}

interface Feedable {
    fun feed(food: String)
}

class Lion(name: String) : Animal(name), Feedable {

    fun hunt() {
        println("$name is hunting in the jungle.")
    }

    override fun makeSound() {
        println("$name: Roar!")
    }

    override fun feed(food: String) {
        println("$name eats $food.")
    }
}

class Elephant(name: String) : Animal(name) {

    fun sprayWater() {
        println("$name sprays water from trunk.")
    }

    override fun makeSound() {
        println("$name: Trumpet!")
    }
}

class Parrot(name: String) : Animal(name) {

    fun fly() {
        println("$name is flying.")
    }

    override fun makeSound() {
        println("$name: Chirp!")
    }
}

fun displayZoo(animals: List<Animal>) {
    println("--- Zoo Tracker ---")
    for (animal in animals) {
        animal.makeSound()
    }
}

fun main() {

    val lion = Lion("Lion")
    val elephant = Elephant("Elephant")
    val parrot = Parrot("Parrot")

    val animals: List<Animal> = listOf(lion, elephant, parrot)

    displayZoo(animals)

    lion.feed("meat")
    elephant.sprayWater()
}