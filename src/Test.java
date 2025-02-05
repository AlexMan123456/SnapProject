public class Test {
    public static void main(String[] args) {
        setupCardAndCardGameClasses();
        System.out.println();
        addExtraMethodsToCardGame();
        System.out.println();
    }

    public static void setupCardAndCardGameClasses(){
        System.out.println("SETTING UP CARD/CARD GAME CLASSES");
        Card card = new Card("♠", "A", 2);
        System.out.println(card); // Should display a string representation of the card object, with suit="♠", symbol="A", and value=2

        CardGame game = new CardGame();
        System.out.println(game.getDeck()); // Should display all cards in the deck
    }

    public static void addExtraMethodsToCardGame(){
        System.out.println("EXTRA CARD GAME METHODS");
        CardGame game = new CardGame();
        Card dealtCard = game.dealCard();
        System.out.println(dealtCard); // Should display the final card in the deck
        System.out.println(game.getDeck().contains(dealtCard)); // Should be false, since dealCard() removes the card from the deck

        game = new CardGame();
        game.sortDeckInNumberOrder();
        System.out.println(game.getDeck()); // Should display the deck sorted by value property

        game.sortDeckIntoSuits();
        System.out.println(game.getDeck()); // Should display the deck sorted by suit

        game = new CardGame();
        game.shuffleDeck();
        System.out.println(game.getDeck()); // Should display the deck shuffled into some random order
    }
}
