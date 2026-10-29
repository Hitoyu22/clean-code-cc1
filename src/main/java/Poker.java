import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Poker {

    public int[] total(List<Hand> hands) {
        int[] points = new int[hands.size()];
        for (int i = 0; i < hands.size(); i++) {
            points[i] = points(hands.get(i));
        }
        return points;
    }

    private int points(Hand hand) {
        if (isBrelan(hand)) {
            return 30;
        }
        return getPointCard(sortedCards(hand).getLast());
    }

    private boolean isBrelan(Hand hand) {

        List<Card> cards = sortedCards(hand);
        int firstCardValue = getPointCard(cards.getFirst());
        int thirdCardValue = getPointCard(cards.get(2));
        int lastCardValue = getPointCard(cards.getLast());

        return firstCardValue == thirdCardValue || thirdCardValue == lastCardValue;
    }

    private List<Card> sortedCards(Hand hand) {
        List<Card> cards = new ArrayList<>(hand.getCards());
        cards.sort(Comparator.comparingInt(Card::getValue));
        return cards;
    }

    private int getPointCard(Card card) {
        return card.getValue();
    }
}
