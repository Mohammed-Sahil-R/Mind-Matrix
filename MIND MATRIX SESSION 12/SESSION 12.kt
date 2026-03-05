/**
 * Theme Switcher & Progress Animator — Student Template
 *
 * Task (2-3 lines):
 * Build a console program that simulates applying light and dark themes to a simple card
 * and "animates" a progress bar by producing a sequence of frames.
 *
 * Instructions (step-by-step):
 * 1) Create a data class `Theme(val name: String, val backgroundLabel: String, val textLabel: String)`
 *    - backgroundLabel and textLabel are simple strings that represent theme styles.
 * 2) Implement `renderCard(title: String, subtitle: String, theme: Theme): String`
 *    - Returns a single string representing the card with theme labels applied (no printing).
 * 3) Implement `animateProgress(totalSteps: Int, width: Int): List<String>`
 *    - Returns a list of strings where each string is a frame showing a progress bar
 *      growing from 0 to width over totalSteps steps (rounded).
 * 4) Implement `applyThemeAndAnimate(title, subtitle, themes)`:
 *    - For each theme in themes:
 *         a) print a header like "--- Applying: <theme.name> ---"
 *         b) print the card (use renderCard)
 *         c) run the animation frames from animateProgress and print each frame
 * 5) In `main()`:
 *    - Create two themes: Light and Dark (use different labels)
 *    - Call applyThemeAndAnimate with a 10-step animation and width of 20.
 *
 * HINTS (in comments only — no solution code here):
 * - Keep renderCard pure: return the string; don't print inside it.
 * - Create a simple ASCII progress bar like: "[#####-----] 25%"
 * - To produce frames: determine how many characters to fill at each step:
 *      filled = ((stepIndex + 1) * width) / totalSteps
 * - Use String.repeat(count) to build the bar parts.
 *
 * Sample Output (example; EXACT formatting expected from instructor solution below):
 *
 * --- Applying: Light ---
 * [Theme: Light | BG: SoftWhite | Text: DarkGray]
 * Card: Welcome — Learn theming (sub: Simulate Material)
 * [####----------------] 20%
 * [########------------] 40%
 * ...
 * --- Applying: Dark ---
 * [Theme: Dark | BG: DeepBlack | Text: LightGray]
 * Card: Welcome — Learn theming (sub: Simulate Material)
 * [####----------------] 20%
 * ...
 *
 * TODOs:
 * // TODO: Define data class Theme(...)
 * // TODO: Implement renderCard(title, subtitle, theme): String
 * // TODO: Implement animateProgress(totalSteps, width): List<String>
 * // TODO: Implement applyThemeAndAnimate(title, subtitle, themes)
 * // TODO: Implement main() to create themes and call applyThemeAndAnimate
 */

// -----------------
// Student code area
// -----------------
data class Theme(
    val name: String,
    val backgroundLabel: String,
    val textLabel: String
)

fun renderCard(title: String, subtitle: String, theme: Theme): String {
    return "[Theme: ${theme.name} | BG: ${theme.backgroundLabel} | Text: ${theme.textLabel}]\n" +
            "Card: $title (sub: $subtitle)"
}

fun animateProgress(totalSteps: Int, width: Int): List<String> {
    val frames = ArrayList<String>()

    for (stepIndex in 0 until totalSteps) {
        val filled = ((stepIndex + 1) * width) / totalSteps
        val empty = width - filled
        val percent = ((stepIndex + 1) * 100) / totalSteps

        val bar = "[" + "#".repeat(filled) + "-".repeat(empty) + "] $percent%"
        frames.add(bar)
    }

    return frames
}

fun applyThemeAndAnimate(
    title: String,
    subtitle: String,
    themes: List<Theme>,
    steps: Int,
    width: Int
) {
    for (theme in themes) {
        println("--- Applying: ${theme.name} ---")
        println(renderCard(title, subtitle, theme))
        val frames = animateProgress(steps, width)
        for (frame in frames) {
            println(frame)
        }
    }
}

fun main() {

    val light = Theme("Light", "SoftWhite", "DarkGray")
    val dark = Theme("Dark", "DeepBlack", "LightGray")

    applyThemeAndAnimate(
        title = "Welcome  Learn theming",
        subtitle = "Simulate Material",
        themes = listOf(light, dark),
        steps = 10,
        width = 20
    )
}