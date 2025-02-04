public class Card {
    private String suit;
    private String symbol;
    private int value;

    // CONSTRUCTOR
    public Card(String suit, String symbol, int value){
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }


    // GETTERS
    public int getValue(){
        return this.value;
    }

    public String getSuit(){
        return this.suit;
    }


    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", symbol='" + symbol + '\'' +
                ", value=" + value +
                '}';
    }
}
