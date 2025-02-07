import java.util.Scanner;

public class Snap extends CardGame {
    private Player[] players;
    private int currentPlayer;

    public Snap(){
        super();
        this.players = new Player[]{new Player("Player one"), new Player("Player two")};
        this.currentPlayer = 0;
    }

    public void playGame(){

        class CustomThread extends Thread {
            final int currentPlayer;
            public CustomThread(int currentPlayer){
                super();
                this.currentPlayer = currentPlayer;
            }
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                    System.out.print(" 1 ");
                    Thread.sleep(1000);
                    System.out.println(" 2 ");
                    Thread.sleep(500);
                    System.out.println(String.format("%s was too slow - %s wins!", players[currentPlayer].getName(), players[getOtherPlayerIndex()].getName()));
                    System.exit(0);
                } catch(InterruptedException exception) {
                    System.exit(0);
                }
            }
        }

        shuffleDeck();
        Scanner scanner = new Scanner(System.in);
        Card previousCard = new Card("Z", "Z", 100);
        Card currentCard;

        do {
            currentCard = dealCard();
            System.out.println(String.format("%s: %s", players[currentPlayer].getName(), currentCard));
            if(previousCard.getValue() == currentCard.getValue()){
                System.out.println("A pair has been found! Type 'snap' to win.");
                CustomThread thread = new CustomThread(currentPlayer);
                thread.start();
                String playerResponse = scanner.nextLine();

                if(playerResponse.equalsIgnoreCase("SNAP")){
                    thread.interrupt();
                    System.out.println(String.format("%s wins!", players[currentPlayer].getName()));
                } else {
                    thread.interrupt();
                    System.out.println(String.format("Invalid response from %s - %s wins!",
                            players[currentPlayer].getName(),
                            players[getOtherPlayerIndex()].getName())
                    );
                }
                break;
            }
            scanner.nextLine();
            previousCard = currentCard;
            swapPlayer();
        } while(this.getDeck().size() > 0);

        if(this.getDeck().size() == 0){
            System.out.println("No match found in deck. No winner.");
        }
        System.out.println("Game ending...");
    }

    private void swapPlayer(){
        this.currentPlayer = getOtherPlayerIndex();
    }

    private int getOtherPlayerIndex(){
        return (new int[]{1,0})[this.currentPlayer];
    }
}
