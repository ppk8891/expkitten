/**
 * Represents a Generic card in the Exploding Kittens game.
 */
public class Generic extends Card {
    private String genericCardArt;
    private static final String TACOCAT_CARD_ART = "ASCII art for TACOCAT_CARD card";
    private static final String CATTERMELON_CARD_ART = "ASCII art for CATTERMELON_CARD card";
    private static final String HAIRY_POTATO_CAT_CARD_ART = "ASCII art for HAIRY_POTATO_CAT_CARD card";
    private static final String RAINBOW_RALPHING_CAT = "ASCII art for RAINBOW_RALPHING_CAT_CARD card";
    private static final String BEARD_CAT_CARD_ART = "ASCII art for BEARD_CAT_CARD card";


    
    /**
     * Constructs an Defuse card object with the specified card ID.
     *
     * @param cardName Name for the card type
     */

    public Generic(String cardName) {
        super(cardName);
        //set card art based on cardName
    }
    
    public void setcardName(String cardName)
    {
        super.setcardName(cardName);
    }

    @Override
    public int cardAction() {
        // Implement the action for Defuse card
        // Return the result of the action as needed
        return 0;
    }


    public String getArt() {
        return genericCardArt;
    }
    
}
