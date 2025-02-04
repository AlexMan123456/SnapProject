public class Main {
    public static void main(String[] args){
        Card card = new Card("♠", "A", 2);
        System.out.println(card);

        CardGame game = new CardGame();
        System.out.println(game.getDeck());
    }
}
