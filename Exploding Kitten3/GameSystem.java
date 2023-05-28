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

    private int posByPlayerID(int playerID)
    {
        int pos = -1;
        for (int i =0;i<players.length;i++)
        {
            if(players[i].getID()==playerID)
            {
                pos = i;
                break;
            }
        }
        return pos;
    }
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
    deck.shuffleDeck();

}
    
    /**
     * Changes the turn to the next player.
     */

    public void changeTurn() {
        if(currPlayerIndex== players.length-1)
        {
            currPlayerIndex = 0;
        }
        else{
            currPlayerIndex +=1;
        }
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
        if (currPlayerIndex >= players.length) {
            currPlayerIndex = 0; // Wrap around to the beginning of the array
        }
        return players[currPlayerIndex];
    }
            /**
     * Checks for winners in the game.
     *
     * @return true - if there is only one player left
     * @return false - if there are moren than one player
     */
    public boolean checkWinners() {
       // System.out.println(players.length);
        if(players.length>1)
        {
            return false;
        }
        else
        {   
            System.out.println("Game Over! Winner is player "+players[0].getID());
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
    public void displayPlayerHand()
    {                   

        for (int i=0;i<players[currPlayerIndex].getCardCount();i++)
        {
            System.out.print(players[currPlayerIndex].getCard(i).getCardName()+" ("+i+")"+" ,");
        }
        System.out.println();
    }
    //method overloading
    public void displayPlayerHand(int pos)
    {                   

        for (int i=0;i<players[pos].getCardCount();i++)
        {
            System.out.print(players[pos].getCard(i).getCardName()+" ("+i+")"+" ,");
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
    
        int player_pos = posByPlayerID(playerID);
        System.out.println("Player "+playerID);
        System.out.println("Played Card Name: "+players[player_pos].getCard(pos).getCardName());
        Card card = players[player_pos].getCard(pos);     
        // For actions that will happens for the played card
        int cardType = card.cardAction();
        
        switch (cardType) {
        case 1: // Attack card
            playAttack(playerID);
            break;
        case 2: // Nope card
            playNope(playerID);
            break;
        case 3: // Skip Card
            playSkip(playerID);
            break;
        case 4: // Favor Card
            playFavor(playerID);
            break;
        case 5: // Shuffle Card
            playShuffle(playerID);
            break;
        case 6: // SeeFuture card
            playSeeFuture(playerID);
            break;
        case 7: // See Generic card
            playGeneric(playerID,card.getCardName()); //extra parameter for generic card
            break;
        case 8: // Exploding Kitten Card
            playExpKitten(playerID);
            break;
        case 9: //Defuse Card
            playDefuse(playerID);
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
     //remove card from player's hand 
     int pos = posByPlayerID(playerID);
     players[pos].removeCard(new Nope("Nope"));
    }

    /**
    * Plays the Attack card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Attack card
    */
    public void playAttack(int playerID) {
    players[playerID].removeCard(new Attack("Attack")); //remove the played card from player's hand

    Scanner input = new Scanner(System.in);

    int nextPlayerIndex = (currPlayerIndex + 1) % players.length;

    // Implementation for playing the Attack card
    //If the next player has the nope card, they will be asked if they are playing the nope card
    if(players[nextPlayerIndex].hasNopeCard())
    {
        System.out.print("Player "+ players[nextPlayerIndex].getID() +" , do you want to play the nope card? (y/n)");
        String choice = input.nextLine();
        if(choice.equals("y"))
        {
            Card card = new Nope("Nope");
            playCard(players[nextPlayerIndex].getID(),players[nextPlayerIndex].getCardPos(card));
        }
        else{
            boolean drawExpKitten;
            drawExpKitten = draw(nextPlayerIndex);
            //next player have to draw two cards
            if(drawExpKitten)
            {
                changeTurn();
                changeTurn();
            }
            else if (draw(nextPlayerIndex))
            {
                changeTurn();
                changeTurn();
            }
            else {
            System.out.println("Player "+nextPlayerIndex+" got "+players[nextPlayerIndex].getCard(players[nextPlayerIndex].getCardCount()-1).getCardName()+" and "+players[nextPlayerIndex].getCard(players[nextPlayerIndex].getCardCount()-2).getCardName());

            // change turn
            changeTurn();
            changeTurn();}

        }
    }
    //if the next player didn't play the nope card
    else
        {
            //next player have to draw two cards
            boolean drawExpKitten;
            drawExpKitten = draw(nextPlayerIndex);
            //next player have to draw two cards
            if(drawExpKitten)
            {
                changeTurn();
                changeTurn();
            }
            else if (draw(nextPlayerIndex))
            {
                changeTurn();
                changeTurn();
            }
            else {
            System.out.println("Player "+nextPlayerIndex+" got "+players[nextPlayerIndex].getCard(players[nextPlayerIndex].getCardCount()-1).getCardName()+" and "+players[nextPlayerIndex].getCard(players[nextPlayerIndex].getCardCount()-2).getCardName());

            // change turn
            changeTurn();
            changeTurn();}
    }
    }

    /**
    * Plays the See Future card for the specified player.
    *
    * @param playerID the ID of the player who is playing the See Future card
    */
    public void playSeeFuture(int playerID) {
        //remove card from player's hand
        players[currPlayerIndex].removeCard(new SeeFuture("SeeFuture"));

        Scanner input = new Scanner(System.in);

        // Implementation for playing the SeeFuture card
 // If the next player has the nope card, they will be asked if they are playing the nope card
 int nextPlayerIndex = (currPlayerIndex + 1) % players.length;
 if (players[nextPlayerIndex].hasNopeCard()) {
     System.out.print("Player " + nextPlayerIndex + ", do you want to play the nope card? (y/n)");
     String choice = input.nextLine();
     if (choice.equals("y")) {
         Card card = new Nope("Nope");
         playCard(nextPlayerIndex, players[nextPlayerIndex].getCardPos(card));
     } else {
        if(deck.getCardCount()>=2){

            System.out.print("The next two cards in the deck are: ");
            System.out.print(deck.getCard(0).getCardName()+" ,");
            System.out.println(deck.getCard(1).getCardName());
        }
        else{
            System.out.println("There are less then two cards in the deck!");
        }
     }
 }        //if the next player don't have the nope card
        else
            {   if(deck.getCardCount()>=2){

                System.out.print("The next two cards in the deck are: ");
                System.out.print(deck.getCard(0).getCardName()+" ,");
                System.out.println(deck.getCard(1).getCardName());
            }
            else{
                System.out.println("There are less then two cards in the deck!");
            }

        }
        
    }

    /**
    * Plays the Shuffle card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Shuffle card
    */
    public void playShuffle(int playerID) {
        //remove card from player's hand
        players[currPlayerIndex].removeCard(new Shuffle("Shuffle"));

        Scanner input = new Scanner(System.in);

        // Implementation for playing the Shuffle card
       // If the next player has the nope card, they will be asked if they are playing the nope card
        int nextPlayerIndex = (currPlayerIndex + 1) % players.length;
        if (players[nextPlayerIndex].hasNopeCard()) {
            System.out.print("Player " + nextPlayerIndex + ", do you want to play the nope card? (y/n)");
            String choice = input.nextLine();
            if (choice.equals("y")) {
                    Card card = new Nope("Nope");
                    playCard(nextPlayerIndex, players[nextPlayerIndex].getCardPos(card));
                 }
            else {
                    deck.shuffleDeck();
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
    int pos = posByPlayerID(playerID);
    // Implementation for playing the Exploding Kitten card
    //Check if the  player Has defuse card
    boolean hasDefuse=false;
    for(int i =0; i<players[pos].getCardCount();i++)
    {   
        if(players[pos].getCard(i).getCardName().equals("Defuse"))
        {
            hasDefuse = true;
            break;
        }
        else
        {
            hasDefuse = false;
        }
    }
    if (hasDefuse==true)
    {
        //play Defuse Card
        //get defuse card position
        int defuseIndex=10;
        for (int i=0;i<players[pos].getCardCount()-1;i++)
        {
            if(players[pos].getCard(i).getCardName().equals("Defuse"))
            {
                defuseIndex=i;
            }
        }
        
        playCard(players[pos].getID(),defuseIndex);
    }
    else {
        System.out.println("Player " + players[pos].getID() + " is removed!");
    
        // Remove player
        players[pos] = null;
        for (int i = pos + 1; i < players.length; i++) {
            if (players[i] != null) {
                players[i - 1] = players[i];
                players[i] = null;
            }
        }
    
        Player[] tempPlayers = new Player[players.length - 1];
            
        for (int i = 0; i < tempPlayers.length; i++) {
            tempPlayers[i] = players[i];
        }
    
        players = tempPlayers;

        System.out.println(players.length + " players remaining");
    }
    
}

    /**
    * Plays the Skip card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Skip card
    */
    public void playSkip(int playerID) {
        Scanner input = new Scanner(System.in);
        //remove card from players hand 
        int pos = posByPlayerID(playerID);
        players[pos].removeCard(new Skip("Skip"));
        int nextPlayerIndex = (currPlayerIndex + 1) % players.length;

        // Implementation for playing the Skip card
        //If the next player has the nope card, they will be asked if they are playing the nope card
        if(players[nextPlayerIndex].hasNopeCard())
        {
            System.out.print("Player "+ players[nextPlayerIndex].getID() +" , do you want to play the nope card? (y/n)");
            String choice = input.nextLine();
            if(choice.equals("y"))
            {
                Card card = new Nope("Nope");
                playCard(players[nextPlayerIndex].getID(),players[nextPlayerIndex].getCardPos(card));
            }
            else
            {
                changeTurn();
            }
        }
        //if the next player didn't play the nope card
        else
            {
                changeTurn();
        }

    }
        /**
    * Plays the Favor card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Favor card
    */
    public void playFavor(int playerID) {
        // Implementation for playing the Favor card
        Scanner input = new Scanner(System.in);

        //remove card from player's hand
        players[currPlayerIndex].removeCard(new Favor("Favor"));

        int nextPlayerIndex = (currPlayerIndex + 1) % players.length;

        // Implementation for playing the Favor card
        //If the next player has the nope card, they will be asked if they are playing the nope card
        if(players[nextPlayerIndex].hasNopeCard())
        {
            System.out.print("Player "+ players[nextPlayerIndex].getID() +" , do you want to play the nope card? (y/n)");
            String choice = input.nextLine();
            if(choice.equals("y"))
            {
                Card card = new Nope("Nope");
                playCard(players[nextPlayerIndex].getID(),players[nextPlayerIndex].getCardPos(card));
            }
            else
            {
                System.out.print("Player "+players[nextPlayerIndex].getID()+", your cards are ");
                displayPlayerHand(nextPlayerIndex);
                System.out.print("Which card do you want to give? (Enter position)");
                int posGivenCard = input.nextInt();
                Card card = players[nextPlayerIndex].getCard(posGivenCard);
                //give card to current player
                players[currPlayerIndex].addCard(card);
                //remove card from next player
                players[nextPlayerIndex].removeCard(card);

            }
        }
        //if the next player didn't play the nope card
        else
            {
                System.out.print("Player "+players[nextPlayerIndex].getID()+", your cards are ");
                displayPlayerHand(nextPlayerIndex);
                System.out.print("Which card do you want to give? (Enter position)");
                int posGivenCard = input.nextInt();
                Card card = players[nextPlayerIndex].getCard(posGivenCard);
                //give card to current player
                players[currPlayerIndex].addCard(card);
                //remove card from next player
                players[nextPlayerIndex].removeCard(card);
        }

        }
    
    /**
    * Plays the Defuse card for the specified player.
    *
    * @param playerID the ID of the player who is playing the Defuse card
    */
    public void playDefuse(int playerID) {
    int pos = posByPlayerID(playerID);
    // Implementation for playing the Defuse card
    //Remove defuse card from player's hand
    players[pos].removeCard(new Defuse("Defuse"));
    //Remove exploding kitten card from player's hand
    players[pos].removeCard(new ExpKitten("ExpKitten"));
    //add exploding kitten card back in the deck
    Scanner input = new Scanner(System.in);
    System.out.println("There are  "+deck.getCardCount()+" cards in the deck");
    System.out.print("Where do you want to put the back the defuse card? Enter position :");
    int in_num = input.nextInt();
    deck.addCard(new ExpKitten("ExpKitten"),in_num);
    changeTurn();
    }

    /**
    * Plays a generic card for the specified player.
    *
    * @param playerID the ID of the player who is playing the generic card
    */
    public void playGeneric(int playerID,String cardName) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int pos = posByPlayerID(playerID);
        //check if there are more then 2 generic cards with same type
        int genericCardCount = 0;
        for (int i =0;i<players[pos].getCardCount();i++)
        {
            if(players[pos].getCard(i).getCardName().equals(cardName))
            {
                genericCardCount+=1;
            }
        }
        if(genericCardCount>=2)
        {
        //remove cards from player's hand
        players[currPlayerIndex].removeCard(new Generic(cardName));
        players[currPlayerIndex].removeCard(new Generic(cardName));
        //check if the next player has Nope card
        int nextPlayerIndex = (currPlayerIndex + 1) % players.length;
        if(players[nextPlayerIndex].hasNopeCard())
        {
            System.out.print("Player "+ players[nextPlayerIndex].getID() +" , do you want to play the nope card? (y/n)");
            String choice = input.nextLine();
            if(choice.equals("y"))
            {
                Card card = new Nope("Nope");
                playCard(players[nextPlayerIndex].getID(),players[nextPlayerIndex].getCardPos(card));
            }
            else
            {
                int cardPos = random.nextInt(players[nextPlayerIndex].getCardCount());
                //give a random card from next player to current player
                Card card = players[nextPlayerIndex].getCard(cardPos);
                players[currPlayerIndex].addCard(card);
                //remove card from next player's hand
                players[nextPlayerIndex].removeCard(card);
                System.out.println("Player "+players[currPlayerIndex].getID()+" got "+ card.getCardName());
     
            }
        }
        else
        {
           int cardPos = random.nextInt(players[nextPlayerIndex].getCardCount());
           //give a random card from next player to current player
           Card card = players[nextPlayerIndex].getCard(cardPos);
           players[currPlayerIndex].addCard(card);
           //remove card from next player's hand
           players[nextPlayerIndex].removeCard(card);
           System.out.println("Player "+players[currPlayerIndex].getID()+" got "+ card.getCardName());
        }

        }
        
        else
        {
            System.out.println("To play a generic card, there should be at least two of them in your hand!");
        }

    }
    public void draw()
    {   
        
        players[currPlayerIndex].addCard(deck.draw());
        System.out.println("Player "+ players[currPlayerIndex].getID()+" drawed "+players[currPlayerIndex].getCard(players[currPlayerIndex].getCardCount()-1).getCardName());
        //if the player draws exploding kitten
      //  System.out.println("Player "+currPlayerIndex+" got "+);
        if(getCurrPlayer().getCard(getCurrPlayer().getCardCount()-1).getCardName().equals("ExpKitten"))
        {
            playCard(currPlayerIndex,getCurrPlayer().getCardCount()-1); //playExpkitten
        }
        else {
            changeTurn();
        }
    }

    //overloading method
    public boolean draw(int pos)
    {   
        boolean drawExpKitten = false;
        players[pos].addCard(deck.draw());
        System.out.println("Player "+ players[pos].getID()+" drawed "+players[pos].getCard(players[pos].getCardCount()-1).getCardName());
        //if the player draws exploding kitten
      //  System.out.println("Player "+currPlayerIndex+" got "+);
        if(players[pos].getCard(players[pos].getCardCount()-1).getCardName().equals("ExpKitten"))
        {
            playCard(players[pos].getID(),players[pos].getCardCount()-1); //playExpkitten
            drawExpKitten = true;
        }
        return drawExpKitten;
    }
}