/**
 * Represents a card in the Exploding Kittens game.
 */
public abstract class Card {
    private String cardName;

    /**
     * Constructs a Card object with the specified card ID.
     *
     * @param cardID the unique identifier for the card
     */
    public Card(String cardName) {
        this.cardName = cardName;
    }
    public String getCardName()
    {
        return cardName;
    }
    public void setcardName(String cardName)
    {
        this.cardName = cardName;
    } 
    /**
     * Performs the action associated with the card.
     * This method needs to be implemented by concrete card classes.
     */
    public abstract int cardAction();
    
}
