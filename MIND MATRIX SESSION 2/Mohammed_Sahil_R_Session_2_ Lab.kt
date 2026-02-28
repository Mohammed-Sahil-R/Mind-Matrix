// =========================================================
// KOTLIN PROJECT LAB
// Topic: Simulating Your First Android App in Kotlin
// =========================================================

@Target(AnnotationTarget.FUNCTION)
annotation class Composable

// Simulating the MainActivity structure
class MainActivity {

    fun onCreate() {
        println("Launching Greeting Card Simulation...")

        // TODO 1 Completed
        setContent {
            GreetingScreen("Sahil")
        }
    }

    // Simulated setContent() method
    private fun setContent(content: () -> Unit) {
        println("Setting up the content...")
        content()
    }
}

// TODO 2 Completed
@Composable
fun GreetingScreen(name: String) {
    println("Hello $name! Welcome to your first Kotlin App!")
}

// TODO 3 Completed
@Composable
fun AppTheme(content: () -> Unit) {
    println("Applying GreetingCard Theme...")
    content()
}

// TODO 4 Completed
fun preview() {
    println("--- Preview Mode ---")
    GreetingScreen("Android Learner")
    println("--- End of Preview ---")
}

// =========================================================
// MAIN FUNCTION – entry point for simulation
// =========================================================

fun main() {

    println("========== Simulated Android App ==========\n")

    val activity = MainActivity()
    activity.onCreate()

    println()

    // TODO 5 Completed
    AppTheme {
        GreetingScreen("Sahil")
    }

    println()

    // TODO 6 Completed
    preview()

    println("\n========== End of Simulation ==========")
}