// Each class should extend the Card class, implement the cardAction() method, and provide the respective ASCII art string

/**
 * Represents a Shuffle card in the Exploding Kittens game.
 */
public class Shuffle extends Card {
    private static final String SHUFFLE_CARD_ART = "ASCII art for Shuffle card";
    /**
     * Constructs an Shuffle card object with the specified card ID.
     *
     * @param cardName Name for the card type
     */

    public Shuffle(String cardName) {
        super(cardName);
    }

    @Override
    public int cardAction() {
        // Implement the action for Shuffle card
        // Return the result of the action as needed
        return 5;
    }


    public String getArt() {
        return SHUFFLE_CARD_ART;
    }
    
}

