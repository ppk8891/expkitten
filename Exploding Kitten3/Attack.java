/**
 * Represents an Attack card in the Exploding Kittens game.
 */
public class Attack extends Card {
    private static final String ATTACK_CARD_ART = "ASCII art for Attack card";

    /**
     * Constructs an Attack card object with the specified card ID.
     *
     * @param cardName Name for the card type
     */
    public Attack(String cardName) {
        super(cardName);
    }

    @Override
    public int cardAction() {
        // Implement the action for Attack card
        // Return the result of the action as needed
        return 1;
    }


    public String getArt() {
        return ATTACK_CARD_ART;
 
    }
    
}
