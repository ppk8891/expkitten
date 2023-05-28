import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameSystem gs;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Welcome! Enter the number of players: ");
        int numPlayers = input.nextInt();
        
        // Consume the newline character
        input.nextLine();
        
        String input_string;
        int input_num;
        gs = new GameSystem(numPlayers);
        
        while (!gs.checkWinners()) {
            System.out.println("Player " + gs.getCurrPlayer().getID() + "'s turn");
            System.out.print("Player " + gs.getCurrPlayer().getID() + "'s cards are: ");
            gs.displayPlayerHand();
            
            System.out.print("Do you want to draw? y/n: ");
            input_string = input.nextLine().trim();
            
            if (input_string.equals("y")) {
                gs.draw();
                System.out.println();
            } else {
                System.out.print("Which card do you want to play? (type position of the card): ");
                input_num = input.nextInt();
                input.nextLine();
                gs.playCard(gs.getCurrPlayer().getID(), input_num);
                System.out.println();
            }
        }
        
        System.out.println(gs.getCurrPlayer().getID());
    }
}
