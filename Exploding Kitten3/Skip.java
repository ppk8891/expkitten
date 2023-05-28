/**
 * Represents a Skip card in the Exploding Kittens game.
 */
public class Skip extends Card {
    private static final String SKIP_CARD_ART = "ASCII art for Skip card";
    /**
     * Constructs an Skip card object with the specified card ID.
     *
     * @param cardName Name for the card type
     */

    public Skip(String cardName) {
        super(cardName);
    }

    @Override
    public int cardAction() {
        // Implement the action for Skip card
        // Return the result of the action as needed
        return 3;
    }

 
    public String getArt() {
        return SKIP_CARD_ART;
    }
    
}