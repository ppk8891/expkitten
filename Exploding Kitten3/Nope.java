/**
 * Represents a Nope card in the Exploding Kittens game.
 */
public class Nope extends Card {
    private static final String NOPE_CARD_ART = "ASCII art for Nope card";

    /**
     * Constructs a Nope card object with the specified card ID.
     *
     * @param cardName Name for the card type
     */
    public Nope(String cardName) {
        super(cardName);
    }

    @Override
    public int cardAction() {
        // Implement the action for Nope card
        // Return the result of the action as needed
        return 2;
    }


    public String getArt() {
        return NOPE_CARD_ART;
    }
}
