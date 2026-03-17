import java.util.LinkedHashMap;
import java.util.Map;

/**
 * OOPSBannerApp is a Java application that prints a large ASCII banner
 * of the word "OOPS" using asterisk (*) characters.
 *
 * <p>A {@code Map<Character, BannerCharacter>} stores one {@link BannerCharacter}
 * per unique letter. The word {@code "OOPS"} is assembled by mapping each
 * character of the word to its stored pattern. A dedicated rendering method
 * iterates the 7 rows and prints each assembled banner line.</p>
 *
 * @author JavaDeveloper
 * @version 7.0
 */
public class UC8 {

    /**
     * Builds and returns the character registry: a {@code Map<Character, BannerCharacter>}
     * keyed by letter, holding one {@link BannerCharacter} per supported glyph.
     *
     * <p>A {@link LinkedHashMap} is used to preserve insertion order, though lookup
     * is always performed by key rather than by iteration order.</p>
     *
     * @return a populated {@code Map<Character, BannerCharacter>} for O, P, and S
     */
    public static Map<Character, BannerCharacter> buildCharacterMap() {
        Map<Character, BannerCharacter> map = new LinkedHashMap<>();
        map.put('O', new BannerCharacter('O'));
        map.put('P', new BannerCharacter('P'));
        map.put('S', new BannerCharacter('S'));
        return map;
    }

    /**
     * Renders a word as an ASCII art banner by iterating every row and
     * assembling each banner line from the patterns stored in the character map.
     *
     * <p>For each of the {@value BannerCharacter#ROW_COUNT} rows, the method
     * looks up every letter of {@code word} in {@code characterMap}, retrieves
     * that row from its {@link BannerCharacter}, and joins the segments with
     * {@code String.join()} before printing the assembled line.</p>
     *
     * @param word         the word to render (e.g. {@code "OOPS"})
     * @param characterMap the map of letter to {@link BannerCharacter} patterns
     * @throws IllegalArgumentException if any letter in {@code word} is absent from the map
     */
    public static void renderBanner(String word,
                                    Map<Character, BannerCharacter> characterMap) {

        // Iterate each of the 7 rows that make up the full banner height
        for (int row = 0; row < BannerCharacter.ROW_COUNT; row++) {

            // For this row, collect one segment per letter in the word
            String[] rowSegments = new String[word.length()];
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                BannerCharacter bc = characterMap.get(letter);
                if (bc == null) {
                    throw new IllegalArgumentException(
                        "No pattern registered for character: '" + letter + "'");
                }
                rowSegments[i] = bc.getRow(row);
            }

            // Join all letter segments for this row and print the banner line
            System.out.println(String.join("  ", rowSegments));
        }
    }

    /**
     * The main method serves as the entry point of the application.
     *
     * <p>Builds the {@code Map<Character, BannerCharacter>} registry, then
     * delegates to {@link #renderBanner(String, Map)} to assemble and print
     * the full "OOPS" ASCII art banner row-by-row.</p>
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Build the registry: Map<Character, BannerCharacter>
        Map<Character, BannerCharacter> characterMap = buildCharacterMap();

        // Assemble and print the "OOPS" banner using the character map
        renderBanner("OOPS", characterMap);

        System.exit(0);
    }
}

/**
 * Encapsulates a single character and its corresponding 7-row ASCII art
 * banner pattern. Each row is assembled using {@code String.join()} to
 * combine fixed-width segments into a uniform-width string.
 *
 * <p>Instances of this class are stored as values in a
 * {@code Map<Character, BannerCharacter>} and retrieved by letter key
 * to assemble multi-character banner displays.</p>
 *
 * @author JavaDeveloper
 * @version 1.0
 */
class BannerCharacter {

    /** The letter this instance represents (e.g. {@code 'O'}, {@code 'P'}, {@code 'S'}). */
    private final char character;

    /**
     * The 7-row ASCII art pattern for this character.
     * Each element is one pre-built row string assembled via {@code String.join()}.
     */
    private final String[] pattern;

    /** Number of rows in every banner character pattern. */
    public static final int ROW_COUNT = 7;

    /**
     * Constructs a {@code BannerCharacter} for the specified letter and
     * immediately builds its 7-row ASCII art pattern.
     *
     * @param character the letter to represent; must be {@code 'O'}, {@code 'P'}, or {@code 'S'}
     * @throws IllegalArgumentException if the character has no defined pattern
     */
    public BannerCharacter(char character) {
        this.character = character;
        this.pattern   = buildPattern(character);
    }

    /**
     * Returns the letter this instance represents.
     *
     * @return the encapsulated character
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Returns the full 7-row ASCII art pattern for this character.
     *
     * @return a {@code String[]} of {@value #ROW_COUNT} rows
     */
    public String[] getPattern() {
        return pattern;
    }

    /**
     * Returns one row of the ASCII art pattern by zero-based index.
     *
     * @param row zero-based row index in the range {@code 0} to {@value #ROW_COUNT}{@code -1}
     * @return the pattern string for the requested row
     * @throws ArrayIndexOutOfBoundsException if {@code row} is outside the valid range
     */
    public String getRow(int row) {
        return pattern[row];
    }

    /**
     * Builds and returns the 7-row ASCII art pattern for the given character.
     * Every row is constructed inline with {@code String.join()} to concatenate
     * fixed-width character segments without a delimiter.
     *
     * @param ch the character to build a pattern for
     * @return a {@code String[]} of {@value #ROW_COUNT} rows
     * @throws IllegalArgumentException if {@code ch} is not a supported letter
     */
    private static String[] buildPattern(char ch) {
        switch (ch) {
            case 'O': return new String[] {
                String.join("", " ", "***", "  "),   // Row 1 —  ***  
                String.join("", "*", "   ", "* "),   // Row 2 — *   * 
                String.join("", "*", "   ", "* "),   // Row 3 — *   * 
                String.join("", "*", "   ", "* "),   // Row 4 — *   * 
                String.join("", "*", "   ", "* "),   // Row 5 — *   * 
                String.join("", "*", "   ", "* "),   // Row 6 — *   * 
                String.join("", " ", "***", "  ")    // Row 7 —  ***  
            };
            case 'P': return new String[] {
                String.join("", "****", " "),         // Row 1 — **** 
                String.join("", "*", "   ", "* "),   // Row 2 — *   * 
                String.join("", "*", "   ", "* "),   // Row 3 — *   * 
                String.join("", "****", " "),         // Row 4 — **** 
                String.join("", "*", "     "),        // Row 5 — *    
                String.join("", "*", "     "),        // Row 6 — *    
                String.join("", "*", "     ")         // Row 7 — *    
            };
            case 'S': return new String[] {
                String.join("", " ", "***", "  "),   // Row 1 —  ***  
                String.join("", "*", "   ", "* "),   // Row 2 — *   * 
                String.join("", "*", "     "),        // Row 3 — *    
                String.join("", " ", "***", "  "),   // Row 4 —  ***  
                String.join("", "    ", "* "),        // Row 5 —     * 
                String.join("", "*", "   ", "* "),   // Row 6 — *   * 
                String.join("", " ", "***", "  ")    // Row 7 —  ***  
            };
            default:
                throw new IllegalArgumentException(
                    "No banner pattern defined for character: '" + ch + "'");
        }
    }
}