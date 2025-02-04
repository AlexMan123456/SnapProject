import java.util.ArrayList;
import java.util.Comparator;

public class CardGame {
    private final ArrayList<Card> deckOfCards = new ArrayList<>();

    // CONSTRUCTOR
    public CardGame(){
        //String[] symbol = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        String[] suits = {"♠","♥","♦","♣"};

        for(String suit: suits){
            for(int value: values){
                this.deckOfCards.add(new Card(suit, this.getCardSymbol(value), value));
            }
        }
    }


    // GETTERS
    public ArrayList<Card> getDeck(){
        return this.deckOfCards;
    }


    // OTHER PUBLIC METHODS
    public Card dealCard(){
        int finalIndexOfDeck = deckOfCards.toArray().length-1;
        Card card = this.deckOfCards.get(finalIndexOfDeck);
        this.deckOfCards.remove(finalIndexOfDeck);
        return card;
    }

    public void sortDeckInNumberOrder(){
        this.deckOfCards.sort(Comparator.comparingInt(Card::getValue));
    }


    // PRIVATE METHODS
    private String getCardSymbol(int value){
        if(value >= 2 && value <= 10){
            return Integer.toString(value);
        }
        return switch(value){
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            case 14 -> "A";
            default -> "";
        };
    }
}
