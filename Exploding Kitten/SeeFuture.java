/**
 * Represents a See Future card in the Exploding Kittens game.
 */
public class SeeFuture extends Card {
    private static final String SEE_FUTURE_CARD_ART = "ASCII art for See Future card";
    /**
     * Constructs an SeeFuture card object with the specified card ID.
     *
     * @param cardName Name for the card type
     */

    public SeeFuture(String cardName) {
        super(cardName);
    }

    @Override
    public int cardAction() {
        // Implement the action for See Future card
        // Return the result of the action as needed
        return 6;
    }


    public String getArt() {
        return SEE_FUTURE_CARD_ART;
    }
}
