/**
 * OOPSBannerApp is a Java application that prints a large ASCII-art banner
 * spelling "OOPS" using asterisks (*) and spaces to the console.
 *
 * <p>Each letter is rendered as a 7-row tall block character composed of
 * '*' and ' ' characters, displayed side by side on the same lines.</p>
 *
 * @author Student
 * @version 2.0
 */
public class UC2 {

    /**
     * ASCII-art rows for the letter O.
     * Each element represents one row of the letter (7 rows total).
     */
    private static final String[] LETTER_O = {
        " *** ",
        "*   *",
        "*   *",
        "*   *",
        "*   *",
        "*   *",
        " *** "
    };

    /**
     * ASCII-art rows for the letter P.
     * Each element represents one row of the letter (7 rows total).
     */
    private static final String[] LETTER_P = {
        "**** ",
        "*   *",
        "*   *",
        "**** ",
        "*    ",
        "*    ",
        "*    "
    };

    /**
     * ASCII-art rows for the letter S.
     * Each element represents one row of the letter (7 rows total).
     */
    private static final String[] LETTER_S = {
        " ****",
        "*    ",
        "*    ",
        " *** ",
        "    *",
        "    *",
        "**** "
    };

    /**
     * Prints the full OOPS banner by combining letter arrays row by row.
     * Letters are separated by a single space column for readability.
     */
    private static void printBanner() {
        String[][] letters = { LETTER_O, LETTER_O, LETTER_P, LETTER_S };
        for (int row = 0; row < 7; row++) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < letters.length; col++) {
                if (col > 0) {
                    line.append(" ");  // gap between letters
                }
                line.append(letters[col][row]);
            }
            System.out.println(line.toString());
        }
    }

    /**
     * The entry point of the application.
     * Prints a large ASCII-art "OOPS" banner to the console, then exits.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        printBanner();
    }
}
