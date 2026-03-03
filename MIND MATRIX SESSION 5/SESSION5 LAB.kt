/**
 * Contact Filter Console — Student Template
 *
 * Task (2-3 lines):
 * Build a small console program that manages and prints a list of contacts.
 * Practice Kotlin fundamentals: data classes, nullability, conditionals, and lambdas.
 *
 * Instructions (step-by-step):
 * 1) Create a data class `Contact` with fields: name:String, phone:String?, email:String?, favorite:Boolean.
 * 2) Implement `formatContact(c: Contact): String` to return a single-line formatted contact.
 *    - If phone or email is null, display "N/A".
 * 3) Implement `filterContacts(contacts: List<Contact>, predicate: (Contact) -> Boolean): List<Contact>`
 *    that returns a new list filtered by the given lambda predicate.
 * 4) Implement `printContacts(title: String, contacts: List<Contact>)` that prints a header then each formatted contact.
 * 5) In `main()` create at least 5 contacts (some with null phone/email, mark some favorites),
 *    then demonstrate:
 *      - printing all contacts,
 *      - printing only favorites using `filterContacts`,
 *      - printing contacts that have an email using `filterContacts`.
 *
 * HINTS (comments only — do not implement here):
 * - Use a data class: data class Contact(val name: String, val phone: String?, val email: String?, val favorite: Boolean)
 * - To format: val phoneDisplay = contact.phone ?: "N/A"
 * - Pass lambdas like: { c -> c.favorite } or { c -> c.email != null }
 * - `filterContacts` can delegate to `contacts.filter(predicate)`
 *
 * Sample Output (exact text, for reference):
 *
 * --- All Contacts ---
 * 1. Maya Patel | Phone: +91-90000-11111 | Email: maya@example.com | ★
 * 2. Raj Sharma | Phone: N/A | Email: raj@sample.com |
 * 3. Li Wei | Phone: +86-13800000000 | Email: N/A |
 * 4. Sara Ali | Phone: N/A | Email: N/A |
 * 5. Tom O'Brien | Phone: +1-555-1234 | Email: tom@example.org | ★
 *
 * --- Favorite Contacts ---
 * 1. Maya Patel | Phone: +91-90000-11111 | Email: maya@example.com | ★
 * 2. Tom O'Brien | Phone: +1-555-1234 | Email: tom@example.org | ★
 *
 * --- Contacts with Email ---
 * 1. Maya Patel | Phone: +91-90000-11111 | Email: maya@example.com | ★
 * 2. Raj Sharma | Phone: N/A | Email: raj@sample.com |
 * 3. Tom O'Brien | Phone: +1-555-1234 | Email: tom@example.org | ★
 *
 * TODOs:
 * // TODO: Define the data class Contact
 * // TODO: Implement formatContact(c: Contact): String
 * // TODO: Implement filterContacts(contacts, predicate)
 * // TODO: Implement printContacts(title, contacts)
 * // TODO: Implement main() to create contacts and demonstrate three prints
 */

// -----------------------------
// Student: write your code below
// -----------------------------

data class Contact(
    val name: String,
    val phone: String?,
    val email: String?,
    val favorite: Boolean
)

fun formatContact(c: Contact): String {
    val phoneDisplay = c.phone ?: "N/A"
    val emailDisplay = c.email ?: "N/A"
    val star = if (c.favorite) "*" else ""
    return "${c.name} | Phone: $phoneDisplay | Email: $emailDisplay | $star"
}

fun filterContacts(
    contacts: List<Contact>,
    predicate: (Contact) -> Boolean
): List<Contact> {
    return contacts.filter(predicate)
}

fun printContacts(title: String, contacts: List<Contact>) {
    println(title)
    contacts.forEachIndexed { index, contact ->
        println("${index + 1}. ${formatContact(contact)}")
    }
    println()
}

fun main() {

    val allContacts = listOf(
        Contact("Maya Patel", "+91-90000-11111", "maya@example.com", true),
        Contact("Raj Sharma", null, "raj@sample.com", false),
        Contact("Li Wei", "+86-13800000000", null, false),
        Contact("Sara Ali", null, null, false),
        Contact("Tom O'Brien", "+1-555-1234", "tom@example.org", true)
    )

    printContacts("--- All Contacts ---", allContacts)

    printContacts(
        "--- Favorite Contacts ---",
        filterContacts(allContacts) { it.favorite }
    )

    printContacts(
        "--- Contacts with Email ---",
        filterContacts(allContacts) { it.email != null }
    )
}