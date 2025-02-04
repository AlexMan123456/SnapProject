import java.util.Scanner;

public class Snap extends CardGame {
    public Snap(){
        super();
    }

    public void playGame(){
        shuffleDeck();
        Scanner scanner = new Scanner(System.in);
        Card previousCard = new Card("Z", "Z", 100);
        Card currentCard;
        do {
            scanner.nextLine();
            currentCard = dealCard();
            System.out.println(currentCard);
            if(previousCard.getValue() == currentCard.getValue()){
                break;
            }
            previousCard = currentCard;
        } while(this.getDeck().size() > 0);
        System.out.println("Pair found - player wins!");
        System.out.println("Game ending...");
    }
}
