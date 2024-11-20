import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private final int playerNumber;
    private final List<Card> hand;
    private final CardDeck leftDeck;
    private final CardDeck rightDeck;
    private final GameState gameState;
    private final int preferredCardValue;

    public Player(int playerNumber, List<Card> hand, CardDeck leftDeck, CardDeck rightDeck, GameState gameState) {
        this.playerNumber = playerNumber;
        this.hand = hand;
        this.leftDeck = leftDeck;
        this.rightDeck = rightDeck;
        this.gameState = gameState;
        this.preferredCardValue = playerNumber;
    }

    public synchronized void addCard(Card card) {
        // Add the card to the player's hand
        hand.add(card);
    }

    public synchronized boolean hasWinningHand() {
        // Check if the player has a winning hand
        int firstValue = hand.getFirst().getValue();
        for (Card card : hand) {
            if (card.getValue() != firstValue) {
                return false;
            }
        }
        return true;
    }

    private Card chooseDiscardCard() {
        // Discard the first card that is not the preferred card value
        for (Card card : hand) {
            if (card.getValue() != preferredCardValue) {
                return card;
            }
        }
        // If all cards are the preferred card value, discard the first card
        return hand.getFirst();
    }

    @Override
    public void run() {

    }

//    Logs and run?
}
