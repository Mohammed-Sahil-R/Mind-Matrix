// -----------------
// Student area
// -----------------

// Data class
data class Profile(val name: String, val title: String, val bio: String)

// Renders ASCII avatar placeholder
fun renderAvatar(width: Int, height: Int): String {
    val sb = StringBuilder()
    val contentWidth = width - 4  // inside border space

    for (i in 0 until height) {
        if (i == height / 2) {
            val text = "Avatar"
            val paddingLeft = (contentWidth - text.length) / 2
            val paddingRight = contentWidth - text.length - paddingLeft
            sb.append("|  ")
            sb.append(" ".repeat(paddingLeft))
            sb.append(text)
            sb.append(" ".repeat(paddingRight))
            sb.append("  |\n")
        } else {
            sb.append("|  ")
            sb.append(" ".repeat(contentWidth))
            sb.append("  |\n")
        }
    }
    return sb.toString()
}

// Renders labeled text block
fun renderTextBlock(label: String, text: String, width: Int): String {
    val contentWidth = width - 4
    val fullText = "$label: $text"
    val trimmedText = if (fullText.length > contentWidth)
        fullText.substring(0, contentWidth)
    else
        fullText

    val padding = contentWidth - trimmedText.length

    return "|  $trimmedText${" ".repeat(padding)}  |\n"
}

// Renders full profile card
fun renderProfile(
    profile: Profile,
    width: Int = 30,
    showAvatar: Boolean = true
): String {
    val sb = StringBuilder()
    val border = "+" + "-".repeat(width - 2) + "+\n"

    sb.append(border)

    if (showAvatar) {
        sb.append(renderAvatar(width, 3))
        sb.append("|${" ".repeat(width - 2)}|\n")
    }

    sb.append(renderTextBlock("Name", profile.name, width))
    sb.append(renderTextBlock("Title", profile.title, width))
    sb.append(renderTextBlock("Bio", profile.bio, width))

    sb.append(border)

    return sb.toString()
}

// Main function
fun main() {
    val p1 = Profile(
        "Ada Lovelace",
        "Software Dev",
        "Early computing pioneer"
    )

    val p2 = Profile(
        "Alan Turing",
        "Mathematician",
        "Father of computer science"
    )

    val p3 = Profile(
        "Grace Hopper",
        "Computer Scientist",
        "COBOL innovator"
    )

    println(renderProfile(p1, 30, true))
    println(renderProfile(p2, 30, false))
    println(renderProfile(p3, 30, true))
}