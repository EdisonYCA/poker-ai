import java.util.HashMap;

public class Card {
    private String suit;
    private String rank;    
    private static HashMap<String, Integer> cardValues = new HashMap<>(); // contains values of each suit
    public static String[] suits = {"Clubs", "Spades", "Hearts", "Diamond"}; // all possible suits
    public static String[] ranks = {"Ace", "Jack", "King", "Queen", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two"}; // all possible ranks
    public static int[] values = {14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2}; // all possible rank values
    
    Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
        buildValues();
    }

    Card(){

    }

    // get suit of a card
    public String getSuit(){
        return suit;
    }

    // get rank of a card
    public String getRank(){
        return rank;
    }

    // intialize hash map that contains values of each rank
    public static void buildValues(){
        for(int i = 12; i >= 0; i--){
            // Key is rank, value is rank value
            cardValues.put(ranks[i], values[i]);
        }
    }

    // get value of a rank
    public int getValue(String rank){
        return cardValues.get(rank);
    }

    // string representation of a card
    public String toString(){
        return String.format("%s of %s", getRank(), getSuit());
    }
}
