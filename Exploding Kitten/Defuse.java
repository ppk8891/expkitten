/**
 * Represents a Defuse card in the Exploding Kittens game.
 */
public class Defuse extends Card {
    private static final String DEFUSE_CARD_ART = "ASCII art for Defuse card";
    /**
     * Constructs an Defuse card object with the specified card ID.
     *
     * @param cardName Name for the card type
     */

    public Defuse(String cardName) {
        super(cardName);
    }

    @Override
    public int cardAction() {
        // Implement the action for Defuse card
        // Return the result of the action as needed
        return 0;
    }

    public String getArt() {
        return DEFUSE_CARD_ART;
    }
    
}
