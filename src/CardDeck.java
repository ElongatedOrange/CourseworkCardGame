import java.util.LinkedList;
import java.util.Queue;

public class CardDeck {
    private final int deckNumber;
    private final Queue<Card> cards;

    public int getDeckNumber() {
        return deckNumber;
    }

    public CardDeck(int deckNumber) {
        this.deckNumber = deckNumber;
        cards = new LinkedList();
    }

    public synchronized void addCard(Card card){
        cards.add(card);
    }

    public synchronized Card drawCard() {
        return cards.poll();
    }

    public synchronized boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public synchronized String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card).append(" ");
        }
        return sb.toString().trim();
    }

}
