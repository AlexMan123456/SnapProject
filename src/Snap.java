import java.util.Scanner;

public class Snap extends CardGame {
    public Snap(){
        super();
    }

    public void playGame(){
        shuffleDeck();
        Player[] players = {new Player("Player one"), new Player("Player two")};
        int currentPlayer = 0;
        Scanner scanner = new Scanner(System.in);
        Card previousCard = new Card("Z", "Z", 100);
        Card currentCard;
        do {
            currentCard = dealCard();
            System.out.println(String.format("%s: %s", players[currentPlayer].getName(), currentCard));
            if(previousCard.getValue() == currentCard.getValue()){
                System.out.println("A pair has been found! Type 'snap' to win.");
                String playerResponse = scanner.nextLine();
                if(playerResponse.equalsIgnoreCase("SNAP")){
                    System.out.println(String.format("%s wins!", players[currentPlayer].getName()));
                } else {
                    System.out.println(String.format("Invalid response from %s - %s wins!",
                            players[currentPlayer].getName(),
                            players[(new int[]{1,0})[currentPlayer]].getName())
                    );
                }
                break;
            }
            scanner.nextLine();
            previousCard = currentCard;
            currentPlayer = (new int[]{1,0})[currentPlayer];
        } while(this.getDeck().size() > 0);
        if(this.getDeck().size() == 0){
            System.out.println("No match found in deck. No winner.");
        }
        System.out.println("Game ending...");
    }
}
