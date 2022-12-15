import java.util.ArrayList;
import java.util.Collections;
public class Deck extends Card {
    public static ArrayList<Card> deck = new ArrayList<>(); // contains all 52 card objects

    Deck(){
        generateDeck();
        shuffleDeck();
    }

    // create deck of cards
    private static void generateDeck(){
        for(int i = 0; i < ranks.length; i++){ // for every rank 
            for(int j = 0; j < suits.length; j++){ // for every suit
                deck.add(new Card(suits[j], ranks[i])); // create new card object of suit and rank
            }
        }
    }

    // shuffle deck of cards
    private static void shuffleDeck(){
        Collections.shuffle(deck);
    }

    // deal card from deck
    public Card dealCard(){
        return deck.remove(0);
    }

}
