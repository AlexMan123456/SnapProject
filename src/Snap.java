import java.util.Scanner;

public class Snap extends CardGame {
    public Snap(){
        super();
    }

    public void playGame(){
        shuffleDeck();
        Player[] players = {new Player("Player one"), new Player("Player two")};
        int currentPlayer = 0;
        boolean pairFound = false;
        Scanner scanner = new Scanner(System.in);
        Card previousCard = new Card("Z", "Z", 100);
        Card currentCard;
        do {
            currentCard = dealCard();
            System.out.println(String.format("%s: %s", players[currentPlayer].getName(), currentCard));
            if(previousCard.getValue() == currentCard.getValue()){
                pairFound = true;
                break;
            }
            scanner.nextLine();
            previousCard = currentCard;
            currentPlayer = (new int[]{1,0})[currentPlayer];
        } while(this.getDeck().size() > 0);
        System.out.println(pairFound ? String.format("Pair found - %s wins!", players[currentPlayer].getName()) : "No pair found. No winner.");
        System.out.println("Game ending...");
    }
}
