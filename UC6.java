/**
 * OOPSBannerApp is a Java application that prints a large ASCII banner
 * of the word "OOPS" using asterisk (*) characters.
 *
 * <p>Each character (O, P, S) has a dedicated helper method that returns
 * its 5-row ASCII pattern as a {@code String[]}. The {@code main} method
 * invokes these helpers inline during array declaration to assemble the
 * full banner, then uses a loop to print every line.</p>
 *
 * @author JavaDeveloper
 * @version 5.0
 */
public class UC6 {

    /**
     * Returns the 5-row ASCII art pattern for the letter 'O'.
     *
     * <p>Each row is built using {@code String.join()} to assemble the
     * character's segments into a padded string.</p>
     *
     * @return a {@code String[]} of 5 elements representing the letter O
     */
    public static String[] getLetterO() {
        return new String[] {
            String.join("", " ", "***", " "),   // Row 1 —  *** 
            String.join("", "*", "   ", "*"),   // Row 2 — *   *
            String.join("", "*", "   ", "*"),   // Row 3 — *   *
            String.join("", "*", "   ", "*"),   // Row 4 — *   *
            String.join("", " ", "***", " ")    // Row 5 —  *** 
        };
    }

    /**
     * Returns the 5-row ASCII art pattern for the letter 'P'.
     *
     * <p>Each row is built using {@code String.join()} to assemble the
     * character's segments into a padded string.</p>
     *
     * @return a {@code String[]} of 5 elements representing the letter P
     */
    public static String[] getLetterP() {
        return new String[] {
            String.join("", "****", " "),   // Row 1 — **** 
            String.join("", "*", "   ", "*"),   // Row 2 — *   *
            String.join("", "****", " "),   // Row 3 — **** 
            String.join("", "*", "    "),   // Row 4 — *    
            String.join("", "*", "    ")    // Row 5 — *    
        };
    }

    /**
     * Returns the 5-row ASCII art pattern for the letter 'S'.
     *
     * <p>Each row is built using {@code String.join()} to assemble the
     * character's segments into a padded string.</p>
     *
     * @return a {@code String[]} of 5 elements representing the letter S
     */
    public static String[] getLetterS() {
        return new String[] {
            String.join("", " ", "***", " "),   // Row 1 —  *** 
            String.join("", "*", "    "),        // Row 2 — *    
            String.join("", " ", "**", "  "),   // Row 3 —  **  
            String.join("", "   ", "*", " "),   // Row 4 —    * 
            String.join("", "***", "  ")        // Row 5 — ***  
        };
    }

    /**
     * The main method serves as the entry point of the application.
     *
     * <p>Invokes the character helper methods inline during {@code String[]}
     * array declaration to assemble each row of the "OOPS" banner.
     * A for-each loop iterates the array and prints every line.</p>
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Retrieve each character's pattern by calling the helper methods
        String[] O1 = getLetterO();
        String[] O2 = getLetterO();
        String[] P  = getLetterP();
        String[] S  = getLetterS();

        // Declare and initialize the banner array at once.
        // Each row is assembled inline with String.join(), combining one
        // row-slice from each character array into a single banner line.
        String[] bannerLines = {
            String.join("  ", O1[0], O2[0], P[0], S[0]),  // Row 1 — tops
            String.join("  ", O1[1], O2[1], P[1], S[1]),  // Row 2 — upper body
            String.join("  ", O1[2], O2[2], P[2], S[2]),  // Row 3 — middle
            String.join("  ", O1[3], O2[3], P[3], S[3]),  // Row 4 — lower body
            String.join("  ", O1[4], O2[4], P[4], S[4])   // Row 5 — bottoms
        };

        // Iterate through the assembled banner and print each line
        for (String line : bannerLines) {
            System.out.println(line);
        }

        System.exit(0);
    }
}