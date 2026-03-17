/**
 * OOPSBannerApp is a Java application that prints a large ASCII banner
 * of the word "OOPS" using asterisk (*) characters.
 *
 * <p>Each letter is constructed line-by-line using {@code String.join()}.
 * All banner lines are stored in a {@code String[]} array and printed
 * using a loop, improving code modularity and reusability.</p>
 *
 * @author JavaDeveloper
 * @version 3.0
 */
public class UC4 {

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
     * Constructs and returns all banner lines for the word "OOPS" as a
     * {@code String} array. Each element represents one row of the ASCII art.
     *
     * @return a {@code String[]} array containing all 5 rows of the banner
     */
    public static String[] buildBanner() {
        return new String[] {
            buildLine(" *** ", " *** ", "**** ", " *** "),  // Row 1 — tops
            buildLine("*   *", "*   *", "*   *", "*    "),  // Row 2 — upper body
            buildLine("*   *", "*   *", "**** ", " **  "),  // Row 3 — middle
            buildLine("*   *", "*   *", "*    ", "   * "),  // Row 4 — lower body
            buildLine(" *** ", " *** ", "*    ", "***  ")   // Row 5 — bottoms
        };
    }

    /**
     * The main method serves as the entry point of the application.
     * It builds the banner array and uses a for-each loop to print each line.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Build all banner lines and store them in a String array
        String[] bannerLines = buildBanner();

        // Iterate through the array and print each line
        for (String line : bannerLines) {
            System.out.println(line);
        }

        System.exit(0);
    }
}