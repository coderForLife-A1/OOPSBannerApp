/**
 * OOPSBannerApp is a Java application that prints a large ASCII banner
 * of the word "OOPS" using asterisk (*) characters.
 *
 * <p>All banner lines are declared and initialized in a single {@code String[]}
 * array using inline {@code String.join()} calls, combining construction and
 * storage concisely. A loop iterates the array to print each line.</p>
 *
 * @author JavaDeveloper
 * @version 4.0
 */
public class UC5 {

    /**
     * The main method serves as the entry point of the application.
     *
     * <p>Declares and initializes a {@code String[]} array where each element
     * is directly assigned an inline {@code String.join()} call that assembles
     * one row of the "OOPS" ASCII art banner. A for-each loop then iterates
     * through the array to print every line to the console.</p>
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Declare and initialize the banner array inline using String.join().
        // Each element combines the corresponding row segments of O, O, P, S
        // into a single formatted line — no separate population step needed.
        String[] bannerLines = {
            String.join("  ", " *** ", " *** ", "**** ", " *** "),  // Row 1 — tops
            String.join("  ", "*   *", "*   *", "*   *", "*    "),  // Row 2 — upper body
            String.join("  ", "*   *", "*   *", "**** ", " **  "),  // Row 3 — middle
            String.join("  ", "*   *", "*   *", "*    ", "   * "),  // Row 4 — lower body
            String.join("  ", " *** ", " *** ", "*    ", "***  ")   // Row 5 — bottoms
        };

        // Iterate through the array and print each banner line
        for (String line : bannerLines) {
            System.out.println(line);
        }

        System.exit(0);
    }
}