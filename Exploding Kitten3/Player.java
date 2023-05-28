/**
 * Represents a player in the Exploding Kittens game.
 */
public class Player {
    private int playerID;
    private Card[] hand;
    

    /**
     * Constructs a Player object with the specified player ID.
     *
     * @param playerID the unique identifier for the player
     */
    public Player(int playerID) {
        this.playerID = playerID;
        this.hand = new Card[1]; //a player will get a defuse card at first
        hand[0] = new Defuse("Defuse");
    }

    /**
     * Retrieves the player ID.
     *
     * @return the player ID
     */
    public int getID() {
        return playerID;
    }
    /*
     * Reterives the length of player's hand
     * @return length of hand array
     */
    public int getCardCount()
    {
        return hand.length;
    }
    /**
     * Adds a card to the player's hand.
     *
     * @param card the card to add
     */
    public void addCard(Card card) {
        // Create a temporary array with one more length
        Card[] tempHand = new Card[hand.length + 1];
        
        // Copy the elements from the hand array to the temporary array
        for (int i = 0; i < hand.length; i++) {
            tempHand[i] = hand[i];
        }
        
        // Add the new card to the last position in the temporary array
        tempHand[hand.length] = card;
        
        // Update the reference to the hand array
        hand = tempHand;
    }
    

    /**
     * Uses a card from the player's hand.
     *
     * @param card the card to use
     */
    public void removeCard(Card card) {
        // Find the index of the card in the hand array
        int index = -1;
        for (int i = 0; i < hand.length; i++) {
            if(hand[i].getCardName().equals(card.getCardName()))
            {
                index = i;
                break;   
            }
        }
        
        // If the card is found, remove it from the hand
        if (index != -1) {
            hand[index] = null; //set the object to null at index where card is found
            //shift cards after null to left
            for (int i = index + 1; i < hand.length; i++) {
                if (hand[i] != null) {
                    hand[i - 1] = hand[i];
                    hand[i] = null;
                }
            }
        }
        //create temp array with one less length
        Card[] tempHand = new Card[hand.length - 1];
        
        // Copy the elements from the hand array to the temporary array
        for (int i = 0; i < tempHand.length; i++) {
            tempHand[i] = hand[i];
        }

        // Update the reference to the hand array
        hand = tempHand;

    }
    public boolean hasNopeCard()
    {
        for (int i =0; i<hand.length;i++){
            if(hand[i].getCardName().equals("Nope"))
            {
                return true;
    
             }
        }
        return false;
       
    }

    public Card getCard(int pos)
    {
        return hand[pos];
    }
    public int getCardPos(Card card)
    {
        int pos = -1;
        for (int i =0; i<hand.length;i++)
        {
            if(hand[i].getCardName().equals(card.getCardName()))
            {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
