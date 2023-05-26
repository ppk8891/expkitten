/**
 * Represents a Nope card in the Exploding Kittens game.
 */
public class Favor extends Card {
    private static final String FAVOR_CARD_ART = "ASCII art for Nope card";

    /**
     * Constructs a Nope card object with the specified card ID.
     *
     * @param cardName Name for the card type
     */
    public Favor(String cardName) {
        super(cardName);
    }

    @Override
    public int cardAction() {
        // Implement the action for Nope card
        // Return the result of the action as needed
        return 0; //dummy value
    }


    public String getArt() {
        return FAVOR_CARD_ART;
    }
}
