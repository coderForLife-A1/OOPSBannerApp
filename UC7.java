/**
 * OOPSBannerApp is a Java application that prints a large ASCII banner
 * of the word "OOPS" using asterisk (*) characters.
 *
 * <p>It creates {@link CharacterPattern} instances for each letter (O, P, S),
 * then uses those instances inline during {@code String[]} array declaration
 * to assemble the 7-row banner. A loop iterates the array to print each line.</p>
 *
 * @author JavaDeveloper
 * @version 6.0
 */
public class UC7 {

    /**
     * The main method serves as the entry point of the application.
     *
     * <p>Creates {@link CharacterPattern} instances for O, P, and S, then
     * declares and initializes the {@code bannerLines} array inline by calling
     * {@link CharacterPattern#getRow(int)} for each row of each character.
     * A for-each loop prints every assembled banner line to the console.</p>
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Instantiate a CharacterPattern for each letter in "OOPS"
        CharacterPattern o1 = new CharacterPattern('O');
        CharacterPattern o2 = new CharacterPattern('O');
        CharacterPattern p  = new CharacterPattern('P');
        CharacterPattern s  = new CharacterPattern('S');

        // Declare and initialize the 7-row banner array inline.
        // Each element joins one row from every CharacterPattern instance,
        // assembling the full "OOPS" line without any separate population step.
        String[] bannerLines = {
            String.join("  ", o1.getRow(0), o2.getRow(0), p.getRow(0), s.getRow(0)),  // Row 1 — tops
            String.join("  ", o1.getRow(1), o2.getRow(1), p.getRow(1), s.getRow(1)),  // Row 2 — upper body
            String.join("  ", o1.getRow(2), o2.getRow(2), p.getRow(2), s.getRow(2)),  // Row 3 — upper mid
            String.join("  ", o1.getRow(3), o2.getRow(3), p.getRow(3), s.getRow(3)),  // Row 4 — middle
            String.join("  ", o1.getRow(4), o2.getRow(4), p.getRow(4), s.getRow(4)),  // Row 5 — lower mid
            String.join("  ", o1.getRow(5), o2.getRow(5), p.getRow(5), s.getRow(5)),  // Row 6 — lower body
            String.join("  ", o1.getRow(6), o2.getRow(6), p.getRow(6), s.getRow(6))   // Row 7 — bottoms
        };

        // Iterate through the assembled banner and print each line
        for (String line : bannerLines) {
            System.out.println(line);
        }

        System.exit(0);
    }
}

/**
 * Encapsulates a single character and its corresponding 7-line ASCII art
 * banner pattern. Each row of the pattern is built using {@code String.join()}
 * to assemble character segments into a fixed-width string.
 *
 * <p>Instances are created for each unique letter needed by the banner
 * (O, P, S) and queried row-by-row to assemble the full "OOPS" display.</p>
 *
 * @author JavaDeveloper
 * @version 1.0
 */
class CharacterPattern {

    /** The character this instance represents (e.g. 'O', 'P', 'S'). */
    private char character;

    /**
     * The 7-line ASCII art pattern for this character.
     * Each element is one row of the banner, pre-built via {@code String.join()}.
     */
    private String[] pattern;

    /**
     * Constructs a {@code CharacterPattern} for the given character,
     * automatically building its 7-line ASCII art pattern.
     *
     * @param character the letter to represent ('O', 'P', or 'S')
     * @throws IllegalArgumentException if the character is not supported
     */
    public CharacterPattern(char character) {
        this.character = character;
        this.pattern   = buildPattern(character);
    }

    /**
     * Returns the character this instance represents.
     *
     * @return the encapsulated character
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Returns the full 7-line ASCII art pattern for this character.
     *
     * @return a {@code String[]} of 7 rows representing the character
     */
    public String[] getPattern() {
        return pattern;
    }

    /**
     * Returns a single row of the ASCII art pattern by index.
     *
     * @param row the zero-based row index (0–6)
     * @return the pattern string for the specified row
     * @throws ArrayIndexOutOfBoundsException if row is outside 0–6
     */
    public String getRow(int row) {
        return pattern[row];
    }

    /**
     * Builds and returns the 7-line ASCII art pattern for the given character
     * using {@code String.join()} to assemble each row from its segments.
     *
     * @param ch the character to build a pattern for ('O', 'P', or 'S')
     * @return a {@code String[]} of 7 rows for the character
     * @throws IllegalArgumentException if {@code ch} is not 'O', 'P', or 'S'
     */
    private static String[] buildPattern(char ch) {
        switch (ch) {
            case 'O': return new String[] {
                String.join("", " ", "***", "  "),  // Row 1 —  ***  
                String.join("", "*", "   ", "* "),  // Row 2 — *   * 
                String.join("", "*", "   ", "* "),  // Row 3 — *   * 
                String.join("", "*", "   ", "* "),  // Row 4 — *   * 
                String.join("", "*", "   ", "* "),  // Row 5 — *   * 
                String.join("", "*", "   ", "* "),  // Row 6 — *   * 
                String.join("", " ", "***", "  ")   // Row 7 —  ***  
            };
            case 'P': return new String[] {
                String.join("", "****", " "),        // Row 1 — **** 
                String.join("", "*", "   ", "* "),  // Row 2 — *   * 
                String.join("", "*", "   ", "* "),  // Row 3 — *   * 
                String.join("", "****", " "),        // Row 4 — **** 
                String.join("", "*", "     "),       // Row 5 — *    
                String.join("", "*", "     "),       // Row 6 — *    
                String.join("", "*", "     ")        // Row 7 — *    
            };
            case 'S': return new String[] {
                String.join("", " ", "***", "  "),  // Row 1 —  ***  
                String.join("", "*", "   ", "* "),  // Row 2 — *   * 
                String.join("", "*", "     "),       // Row 3 — *    
                String.join("", " ", "***", "  "),  // Row 4 —  ***  
                String.join("", "    ", "* "),       // Row 5 —     * 
                String.join("", "*", "   ", "* "),  // Row 6 — *   * 
                String.join("", " ", "***", "  ")   // Row 7 —  ***  
            };
            default:
                throw new IllegalArgumentException(
                    "Unsupported character: '" + ch + "'. Supported: O, P, S");
        }
    }
}