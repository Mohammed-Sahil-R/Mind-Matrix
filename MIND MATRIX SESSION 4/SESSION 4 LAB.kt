data class BusinessCard(
    val name: String,
    val title: String,
    val phone: String,
    val email: String
)

const val CARD_WIDTH = 50

fun centerText(text: String, width: Int): String {
    if (text.length >= width) return text.take(width)
    val padding = (width - text.length) / 2
    val rightPadding = width - text.length - padding
    return " ".repeat(padding) + text + " ".repeat(rightPadding)
}

fun printBorder(width: Int) {
    println("-".repeat(width))
}

fun printEmptyLine(width: Int) {
    println("|" + " ".repeat(width - 2) + "|")
}

fun printLogo(width: Int) {
    val logoText = "[ANDROID]"
    println("|" + centerText(logoText, width - 2) + "|")
}

fun printHeader(card: BusinessCard, width: Int) {
    println("|" + centerText(card.name, width - 2) + "|")
    println("|" + centerText(card.title, width - 2) + "|")
}

fun printContacts(card: BusinessCard, width: Int, showContacts: Boolean) {
    if (!showContacts) return
    val phoneLine = "  Phone: ${card.phone}"
    val emailLine = "  Email: ${card.email}"
    println("|" + phoneLine.padEnd(width - 2, ' ') + "|")
    println("|" + emailLine.padEnd(width - 2, ' ') + "|")
}

fun main() {

    val card = BusinessCard(
        name = "MOHAMMED SAHIL R",
        title = " Android Developer",
        phone = "+91-87923 55372",
        email = "Mohammedsahilr39@gmail.com"
    )

    val showContacts = true

    printBorder(CARD_WIDTH)
    printLogo(CARD_WIDTH)
    printEmptyLine(CARD_WIDTH)
    printHeader(card, CARD_WIDTH)
    printEmptyLine(CARD_WIDTH)
    printContacts(card, CARD_WIDTH, showContacts)
    printBorder(CARD_WIDTH)
}