public class ExpKitten extends Card {
    private static final String EXP_KITTEN_CARD_ART = "ASCII art for Exploding Kitten card";

    /**
     * Constructs an ExpKitten card object with the specified card ID.
     *
     * @param cardName Name for the card type
     */

    public ExpKitten(String cardName) {
        super(cardName);
    }

    @Override
    public int cardAction() {
        // Implement the action for Exploding Kitten card
        // Return the result of the action as needed
        return 0;
    }


    public String getArt() {
        return EXP_KITTEN_CARD_ART;
    }
    
}
