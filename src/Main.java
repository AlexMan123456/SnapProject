public class Main {
    public static void main(String[] args){
        stageOneTests();
        System.out.println();
        stageTwoTests();
    }

    public static void stageOneTests(){
        System.out.println("STAGE 1 TESTS");
        Card card = new Card("♠", "A", 2);
        System.out.println(card);

        CardGame game = new CardGame();
        System.out.println(game.getDeck());
    }

    public static void stageTwoTests(){
        System.out.println("STAGE 2 TESTS");
        CardGame game = new CardGame();
        System.out.println(game.dealCard());

        game = new CardGame();
        game.sortDeckInNumberOrder();
        System.out.println(game.getDeck());

        game.sortDeckIntoSuits();
        System.out.println(game.getDeck());

        game = new CardGame();
        game.shuffleDeck();
        System.out.println(game.getDeck());
    }
}
