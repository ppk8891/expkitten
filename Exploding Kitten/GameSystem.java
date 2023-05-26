import java.util.Random;
import java.util.Scanner;
/**
 * Represents the game system of the Exploding Kittens game.
 */

public class GameSystem{
    private int numPlayers;
    private Player [] players;
    private MainDeck deck;
    private int currPlayerIndex;
    
    // Private Methods
    /**
    * Determines the type of a card and returns an integer representing the card type.
    *
    * @param card the card object to determine the type of
    * @return an integer representing the card type:
    * @return 1 - Nope card
    * @return 2 - Attack card
    * @return 3 - Shuffle card
    * @return 4 - Skip card
    * @return 5 - Exploding Kitten card
    * @return 6 - Defuse card
    * @return 7 - See Future card
    * @return 8 - Generic card (for any other card types)
    */

    // Public Methods
     /**
     * Constructs a GameSystem object with the specified number of players.
     *
     * @param numPlayers the number of players in the game
     */
    public GameSystem(int numPlayers) {
    this.numPlayers = numPlayers;
    players = new Player[this.numPlayers];
    
    //create players
    for(int i=0; i<this.numPlayers;i++)
    {
        players[i]= new Player(i); //add a new player with ID starting from zero
    } 
    //initiate the deck 
    deck = new MainDeck();
    //add cards to players
    deck.shuffleDeck();
    //each player will get 4 cards from the deck
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < numPlayers; j++) {
            players[j].addCard(deck.draw());
        }
    }
    setCurrPlayer(0); //start from player 0;
    switch(numPlayers){
        case 2:
        deck.addCard(new ExpKitten("ExpKitten"));
        deck.addCard(new Defuse("Defuse"));
        deck.addCard(new Defuse("Defuse"));
        deck.addCard(new Defuse("Defuse"));
        deck.addCard(new Defuse("Defuse"));
        break;
        case 3:
        deck.addCard(new ExpKitten("ExpKitten"));
        deck.addCard(new Defuse("ExpKitten"));
        deck.addCard(new Defuse("Defuse"));
        deck.addCard(new Defuse("Defuse"));
        deck.addCard(new Defuse("Defuse"));
        break;
        case 4:
        deck.addCard(new ExpKitten("ExpKitten"));
        deck.addCard(new Defuse("ExpKitten"));
        deck.addCard(new Defuse("ExpKitten"));
        deck.addCard(new Defuse("Defuse"));
        deck.addCard(new Defuse("Defuse"));
        break;
        case 5:
        deck.addCard(new ExpKitten("ExpKitten"));
        deck.addCard(new Defuse("ExpKitten"));
        deck.addCard(new Defuse("ExpKitten"));
        deck.addCard(new Defuse("ExpKitten"));
        deck.addCard(new Defuse("Defuse"));
        break;
        default:
        System.out.println("Number of players can only be 2 - 5");
        break;
    }

}
    
    /**
     * Changes the turn to the next player.
     */

    public void changeTurn() {
        currPlayerIndex = currPlayerIndex+1; // change currPlayerIndex to the next player
    
    }
    /**
     * Sets the current player.
     *
     * @param playerPos the position of the player to set as the current player
     */

    public void setCurrPlayer(int playerPos) {
        currPlayerIndex = playerPos; // set currPlayerIndex
    }
    /**
     * Retrieves the current player.
     *
     * @return the current player
     */

    public Player getCurrPlayer() {
        return players[currPlayerIndex];
    }
        /**
     * Checks for winners in the game.
     *
     * @return true - if there is only one player left
     * @return false - if there are moren than one player
     */
    public boolean checkWinners() {
        System.out.println(players.length);
        if(players.length>1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    /**
     * Retrieves the count of cards in the deck.
     *
     * @return the count of cards in the deck
     */
    public int getCardCount() {
        return deck.getCardCount();
    }
    /**
     * Display Player Hand
     */
    public void displayPlayerHand(int playerID)
    {                   

        for (int i=0;i<players[playerID].getCardCount();i++)
        {
            System.out.print(players[playerID].getCard(i).getCardName()+" ,");
        }
        System.out.println();
    }

    /**
     * Adds a card to a player's hand.
     *
     * @param playerID the ID of the player
     * @param card     the card to add
     */

    public void addCard(int playerID, Card card) {
        Player player = players[playerID];
        player.addCard(card);
    }

    /**
     * Removes a card from a player's hand.
     *
     * @param playerID the ID of the player
     * @param card     the card to remove
     */
    public void removeCard(int playerID, Card card) {
        Player player = players[playerID];
        player.removeCard(card);
    }

     /**
     * Plays a card from a player's hand.
     *
     * @param playerID the ID of the player
     * @param card     the card to play
     */
    //public void diplayPlayerHand(int playerID){}

    public void playCard(int playerID, int pos) {
        Card card = players[playerID].getCard(pos); 
        
        // For actions that will happens for the played card
        int cardType = card.cardAction();
        
        switch (cardType) {
        case 1: // Nope card
            playAttack(playerID);
            break;
        case 2: // Attack card
            playNope(playerID);
            break;
        case 3: // Shuffle card
            playSkip(playerID);
            break;
        case 4: // Skip card
            playFavor(playerID);
            break;
        case 5: // Exploding Kitten card
            playShuffle(playerID);
            break;
        case 6: // Defuse card
            playSeeFuture(playerID);
            break;
        case 7: // See Future card
            playGeneric(playerID);
            break;
        case 8: // Generic card
            // Handle the generic card case or call a generic card method
            break;
        default:
            // Handle unknown or invalid card type
            System.out.println("Invalid Card Type");
            break;
    }
    }
        
    /**
    * Plays the Nope card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Nope card
     */
    public void playNope(int playerID) {
     // Implementation for playing the Nope card
    }

    /**
    * Plays the Attack card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Attack card
    */
    public void playAttack(int playerID) {
    players[playerID].removeCard(new Attack("Attack")); //remove the played card from player's hand

    Scanner input = new Scanner(System.in);
    
    // Implementation for playing the Attack card
    //If the next player has the nope card, they will be asked if they are playing the nope card
    if(players[currPlayerIndex+1].hasNopeCard())
    {
        System.out.print("Player "+ currPlayerIndex+1 +" , do you want to play the nope card? (y/n)");
        String choice = input.nextLine();
        if(choice.equals("y"))
        {
            Card card = new Nope("Nope");
            playCard(currPlayerIndex+1,card.cardAction());
        }
    }
    //if the next player didn't play the nope card
    else
        {
            //next player have to draw two cards
            players[currPlayerIndex+1].addCard(deck.draw());
            players[currPlayerIndex+1].addCard(deck.draw());
            // set current player to current player + 2
            setCurrPlayer(currPlayerIndex+2);
    }
    }

    /**
    * Plays the See Future card for the specified player.
    *
    * @param playerID the ID of the player who is playing the See Future card
    */
    public void playSeeFuture(int playerID) {
        Scanner input = new Scanner(System.in);

        // Implementation for playing the SeeFuture card
        //If the next player has the nope card, they will be asked if they are playing the nope card
        if(players[currPlayerIndex+1].hasNopeCard())
        {
            System.out.print("Player "+ (currPlayerIndex+1) +" , do you want to play the nope card? (y/n)");
            String choice = input.nextLine();
            if(choice.equals("y"))
            {
                Card card = new Nope("Nope");
                playCard(currPlayerIndex+1,card.cardAction());
            }
            // don't play nope card
            else
            {
                System.out.print("The next two cards in the deck are: ");
                System.out.print(deck.getCard(0).getCardName()+" ,");
                System.out.println(deck.getCard(1).getCardName());
               }
        }
        //if the next player don't have the nope card
        else
            {
                System.out.print("The next two cards in the deck are: ");
                System.out.print(deck.getCard(0).getCardName()+" ,");
                System.out.println(deck.getCard(1).getCardName());
        }
        
    }

    /**
    * Plays the Shuffle card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Shuffle card
    */
    public void playShuffle(int playerID) {
        Scanner input = new Scanner(System.in);

        // Implementation for playing the Shuffle card
        //If the next player has the nope card, they will be asked if they are playing the nope card
        if(players[currPlayerIndex+1].hasNopeCard())
        {
            System.out.print("Player "+ currPlayerIndex+1 +" , do you want to play the nope card? (y/n)");
            String choice = input.nextLine();
            if(choice.equals("y"))
            {
                Card card = new Nope("Nope");
                playCard(currPlayerIndex+1,card.cardAction());
            }
        }
        //if the next player didn't play the nope card
        else
            {
                deck.shuffleDeck();
        }

    }

    /**
    * Plays the Exploding Kitten card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Exploding Kitten card
     */
    public void playExpKitten(int playerID) {
    // Implementation for playing the Exploding Kitten card
    //Check if the  player Has defuse card
    boolean hasDefuse=true;
    for(int i =0; i<players[currPlayerIndex].getCardCount();i++)
    {   
        if(players[currPlayerIndex].getCard(i).getCardName().equals("Defuse"))
        {
            hasDefuse = true;
        }
        else
        {
            hasDefuse = false;
        }
    }
    if (hasDefuse==true)
    {
        //play Defuse Card
        //playCard(currPlayerIndex,new Defuse("Defuse"));
    }
    else
    {
        //remove player
        for (int i = currPlayerIndex + 1; i < players.length; i++) {
            if (players[currPlayerIndex] != null) {
                players[currPlayerIndex - 1] = players[currPlayerIndex];
                players[currPlayerIndex] = null;
            }

    }
    
    }
}

    /**
    * Plays the Skip card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Skip card
    */
    public void playSkip(int playerID) {
        Scanner input = new Scanner(System.in);

        // Implementation for playing the Skip card
        //If the next player has the nope card, they will be asked if they are playing the nope card
        if(players[currPlayerIndex+1].hasNopeCard())
        {
            System.out.print("Player "+ currPlayerIndex+1 +" , do you want to play the nope card? (y/n)");
            String choice = input.nextLine();
            if(choice.equals("y"))
            {
                Card card = new Nope("Nope");
                playCard(currPlayerIndex+1,card.cardAction());
            }
        }
        //if the next player didn't play the nope card
        else
            {
                setCurrPlayer(currPlayerIndex+1);
        }

    }
        /**
    * Plays the Favor card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Favor card
    */
    public void playFavor(int playerID) {
        // Implementation for playing the Favor card
        }
    
    /**
    * Plays the Defuse card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Defuse card
    */
    public void playDefuse(int playerID) {
    // Implementation for playing the Defuse card
    }

    /**
    * Plays a generic card for the specified player.
    *
    * @param playerID the ID of the player who is playing the generic card
    */
    public void playGeneric(int playerID) {
        Scanner input = new Scanner(System.in);

        // Implementation for playing the Generic cards
        //If the next player has the nope card, they will be asked if they are playing the nope card
        if(players[currPlayerIndex+1].hasNopeCard())
        {
            System.out.print("Player "+ currPlayerIndex+1 +" , do you want to play the nope card? (y/n)");
            String choice = input.nextLine();
            if(choice.equals("y"))
            {
                Card card = new Nope("Nope");
                playCard(currPlayerIndex+1,card.cardAction());
            }
        }
        //if the next player didn't play the nope card
        else
            {
    
        }
    }
    public void draw()
    {
        players[currPlayerIndex].addCard(deck.draw());
        setCurrPlayer(currPlayerIndex+1);
    }

}