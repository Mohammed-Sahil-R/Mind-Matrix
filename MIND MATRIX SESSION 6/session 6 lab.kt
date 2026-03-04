/**
 * Dice Roller Console — Student Template
 *
 * Task (2-3 lines):
 * Create a small console program that simulates a Dice Roller "button" — every press rolls two dice.
 * Practice state updates, functions, and conditional output (e.g., show a special message on a double).
 *
 * Instructions (step-by-step):
 * 1) Create a function rollDie(sides: Int, rnd: kotlin.random.Random): Int that returns a number 1..sides.
 * 2) Create a function rollTwoDice(rnd: kotlin.random.Random): Pair<Int, Int> that rolls two six-sided dice.
 * 3) Create a function formatRoll(rollNumber: Int, a: Int, b: Int): String that returns a nicely formatted line.
 *    - If both dice show the same value (a double), append " -> Double!" to the line.
 * 4) In main(), create a Random instance (you can seed for reproducible output).
 * 5) Simulate pressing the "Roll" button three times by calling rollTwoDice three times,
 *    incrementing a roll counter each time and printing the formatted result.
 *
 * HINTS (in comments only — do not provide full logic here):
 * - Use kotlin.random.Random for randomness: val rnd = Random(123)
 * - rollDie can return rnd.nextInt(1, sides + 1)
 * - Use a counter variable: var rollNumber = 0; increment on each simulated press
 * - formatRoll should use string templates: "Roll $rollNumber: $a and $b"
 *
 * Sample Output (exact text expected from a seeded run):
 *
 * --- Dice Roller ---
 * Pressing 'Roll'...
 * Roll 1: 2 and 5
 * Pressing 'Roll'...
 * Roll 2: 6 and 6 -> Double!
 * Pressing 'Roll'...
 * Roll 3: 1 and 4
 *
 * TODOs:
 * // TODO: Implement rollDie(sides: Int, rnd: Random): Int
 * // TODO: Implement rollTwoDice(rnd: Random): Pair<Int, Int>
 * // TODO: Implement formatRoll(rollNumber: Int, a: Int, b: Int): String
 * // TODO: Implement main(): simulate 3 button presses and print results
 */

// --------------
// Student code
// --------------

import kotlin.random.Random

fun rollDie(sides: Int, rnd: Random): Int {
    return rnd.nextInt(1, sides + 1)
}

fun rollTwoDice(rnd: Random): Pair<Int, Int> {
    val a = rollDie(6, rnd)
    val b = rollDie(6, rnd)
    return Pair(a, b)
}

fun formatRoll(rollNumber: Int, a: Int, b: Int): String {
    val result = "Roll $rollNumber: $a and $b"
    return if (a == b) "$result -> Double!" else result
}

fun main() {
    val rnd = Random(123)
    var rollNumber = 0

    println("--- Dice Roller ---")

    repeat(3) {
        println("Pressing 'Roll'...")
        rollNumber++
        val (a, b) = rollTwoDice(rnd)
        println(formatRoll(rollNumber, a, b))
    }
}