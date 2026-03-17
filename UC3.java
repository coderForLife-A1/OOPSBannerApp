/**
 * OOPSBannerApp is a Java application that prints a large ASCII banner
 * of the word "OOPS" using asterisk (*) characters.
 *
 * <p>Each letter is constructed line-by-line using {@code String.join()}
 * to assemble segments into complete rows, then printed to the console.</p>
 *
 * @author JavaDeveloper
 * @version 2.0
 */
public class UC3 {

    /**
     * Builds a single horizontal line of the banner by joining letter segments
     * with a space separator using {@code String.join()}.
     *
     * @param segments one string segment per letter for the current row
     * @return a single formatted banner line with letters separated by spaces
     */
    public static String buildLine(String... segments) {
        return String.join("  ", segments);
    }

    /**
     * The main method serves as the entry point of the application.
     * It prints a multi-line ASCII art banner spelling "OOPS" using * characters.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Each letter is 5 rows tall, built row by row using String.join()

        // Row 1
        System.out.println(buildLine(" *** ", " *** ", "**** ", " *** "));
        // Row 2
        System.out.println(buildLine("*   *", "*   *", "*   *", "*    "));
        // Row 3
        System.out.println(buildLine("*   *", "*   *", "**** ", " **  "));
        // Row 4
        System.out.println(buildLine("*   *", "*   *", "*    ", "   * "));
        // Row 5
        System.out.println(buildLine(" *** ", " *** ", "*    ", "***  "));

        System.exit(0);
    }
}