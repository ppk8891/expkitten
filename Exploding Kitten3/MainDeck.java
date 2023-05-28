import java.util.Random;

/**
 * Represents the main deck of cards in the Exploding Kittens game.
 */
public class MainDeck {
    private Card[] deck;
    private int topCardIndex;

    private Card createCard(String cardType)
    {
        Card card; 
        if (cardType.equals("Attack"))
        {
            card = new Attack(cardType);
            return card;
        }
        else if (cardType.equals("Nope"))
        {
            card = new Nope(cardType);
            return card;
        }
        else if (cardType.equals("Skip"))
        {
            card = new Skip(cardType);
            return card;
        }
        else if (cardType.equals("Favor"))
        {
            card = new Favor(cardType);
            return card;
        }
        else if (cardType.equals("Shuffle"))
        {   
            card = new Shuffle(cardType);
            return card;
        }
        else if (cardType.equals("SeeFuture"))
        {
            card = new SeeFuture(cardType);
            return card;
        }

        else if (cardType.equals("Generic"))
        {   
            card = new Generic(cardType);
            return card;
        }

        else if (cardType.equals("ExpKitten"))
        {
            card = new ExpKitten(cardType);
            return card;
        }
        else if (cardType.equals("Defuse"))
        {
            card = new Defuse(cardType);
            return card;
        }
        else
        {
            return null;
        }

    }
    /**
     * Constructs a MainDeck object and initializes the deck according to the number of players.
     *
     */
    public MainDeck() {
        // initiate the deck according to the number of players
        // Define the card types and their counts

        deck = new Card[46]; //size of deck is always 51 no matter the player numbers

        // All cards except Exploding Kitten and Defuse also stay the same
        String[] cardTypes = {"Attack","Nope", "Skip", "Favor", "Shuffle", "SeeFuture", "Generic"};

        // 4 for attack,skip,favor,shuffle, 5 for see future, and 20 generic cards
        int[] cardCounts = {4, 5, 4, 4, 4, 5, 20};


        int index = 0;

        // Loop over the card types and add the corresponding number of cards to the deck
        for (int i = 0; i < cardTypes.length; i++) {
            for (int j = 0; j < cardCounts[i]; j++) {
                deck[index] = createCard(cardTypes[i]);
                index++;
                }
        }
        //Assign Generic Cards
        //from index 26 to index 46 are Generic cards
        for(int i = 26; i<46; i+=5)
        {   
            deck[i].setcardName("TACOCAT_CARD");
            deck[i+1].setcardName("CATTERMELON_CARD");
            deck[i+2].setcardName("HAIRY_POTATO_CAT_CARD");
            deck[i+3].setcardName("RAINBOW_RALPHING_CAT_CARD");
            deck[i+4].setcardName("BEARD_CAT_CARD");
        }
        
    }
    

    /**
     * Returns the count of cards in the deck.
     *
     * @return the count of cards in the deck
     */
    public int getCardCount() {
        return deck.length;
    }
    public Card getCard(int pos)
    {
        return deck[pos];
    }

    /**
     * Draws a card from the deck and reduces the size of the deck
     */
    public Card draw() {
        Card card = deck[0]; //get the first card from deck

        Card [] tempDeck = new Card[deck.length - 1]; //create temporary deck

        //reduce the deck (dynnamic array)
        for (int i = 1; i < deck.length; i++) {
            tempDeck[i - 1] = deck[i];
        }
        deck = tempDeck;

        //return the first card
        return card;
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffleDeck() {
        Random random = new Random();

        for (int i = 0; i <deck.length ; i++) {
            int j = random.nextInt(i + 1);

            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }
    public void addCard(Card card)
    {
        Card[] tempDeck = new Card[deck.length+1];
        for (int i=0;i<deck.length;i++)
        {
            tempDeck[i] = deck[i];
        }
        tempDeck[tempDeck.length-1] = card;
        deck = tempDeck;
        shuffleDeck();
    }

    //Method overloading
    public void addCard(Card card, int pos) {
        if (pos < 0 || pos > deck.length) {
            throw new IllegalArgumentException("Invalid position");
        }
    
        Card[] tempDeck = new Card[deck.length + 1];
        for (int i = 0; i < pos; i++) {
            tempDeck[i] = deck[i];
        }
        tempDeck[pos] = card;
        for (int i = pos + 1; i < tempDeck.length; i++) {
            tempDeck[i] = deck[i - 1];
        }
        deck = tempDeck;
    }
        

}
