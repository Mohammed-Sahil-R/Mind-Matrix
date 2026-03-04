/**
 * Tip Calculator Console — Student Template
 *
 * Task (2-3 lines):
 * Build a small console program that calculates the tip for a bill amount.
 * Practice writing pure functions, using parameters, and conditional logic (round-up option).
 *
 * Instructions (step-by-step):
 * 1) Create a function calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double
 *    - Computes the tip as amount * tipPercent / 100.0
 *    - If roundUp is true, round the tip up to the next whole rupee/dollar using kotlin.math.ceil
 *    - Return the tip amount (as a Double).
 * 2) Create a function formatAmount(amount: Double): String that returns the amount formatted with two decimal places.
 *    - Use String.format with Locale.US to ensure decimal point formatting.
 * 3) In main(), prepare at least three sample scenarios (different amounts and tipPercents and roundUp true/false).
 *    - For each scenario: compute the tip using calculateTip and print a line with the bill amount, tip percent,
 *      whether round-up is enabled, and the formatted tip amount.
 *
 * HINTS (comments only — do not implement here):
 * - Use kotlin.math.ceil to round up: val rounded = kotlin.math.ceil(value)
 * - To format two decimals: String.format(Locale.US, "%.2f", amount)
 * - Keep calculations in Double to avoid integer truncation
 * - Example function signature: fun calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double
 *
 * Sample Output (example for guidance):
 *
 * Bill: 50.00 | Tip percent: 15% | Round up: false | Tip: 7.50
 * Bill: 75.20 | Tip percent: 18% | Round up: true  | Tip: 14.00
 * Bill: 100.00 | Tip percent: 20% | Round up: false | Tip: 20.00
 *
 * TODOs:
 * // TODO: Implement calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double
 * // TODO: Implement formatAmount(amount: Double): String
 * // TODO: Implement main() to run three sample scenarios and print results
 */

// -----------------
// Student code area
// -----------------

import java.util.Locale
import kotlin.math.ceil

fun calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double {
    var tip = amount * tipPercent / 100.0
    if (roundUp) {
        tip = ceil(tip)
    }
    return tip
}

fun formatAmount(amount: Double): String {
    return String.format(Locale.US, "%.2f", amount)
}

fun main() {

    val amount1 = 50.00
    val percent1 = 15
    val round1 = false
    val tip1 = calculateTip(amount1, percent1, round1)

    println("Bill: ${formatAmount(amount1)} | Tip percent: ${percent1}% | Round up: $round1 | Tip: ${formatAmount(tip1)}")

    val amount2 = 75.20
    val percent2 = 18
    val round2 = true
    val tip2 = calculateTip(amount2, percent2, round2)

    println("Bill: ${formatAmount(amount2)} | Tip percent: ${percent2}% | Round up: $round2 | Tip: ${formatAmount(tip2)}")

    val amount3 = 100.00
    val percent3 = 20
    val round3 = false
    val tip3 = calculateTip(amount3, percent3, round3)

    println("Bill: ${formatAmount(amount3)} | Tip percent: ${percent3}% | Round up: $round3 | Tip: ${formatAmount(tip3)}")
}