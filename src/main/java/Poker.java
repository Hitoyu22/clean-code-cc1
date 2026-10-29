import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Poker {

    private static final int BRELAN_POINTS = 30;

    public int[] total(List<Hand> hands) {
        int[] points = new int[hands.size()];
        for (int i = 0; i < hands.size(); i++) {
            points[i] = points(hands.get(i));
        }
        return points;
    }

    private int points(Hand hand) {
        if (isBrelan(hand)) {
            return BRELAN_POINTS;
        }
        return getHighCard(hand);
    }

    private boolean isBrelan(Hand hand) {

        List<Card> cards = sortedCards(hand);
        int firstCardValue = getPointCard(cards.getFirst());
        int thirdCardValue = getPointCard(cards.get(2));
        int lastCardValue = getPointCard(cards.getLast());

        return firstCardValue == thirdCardValue || thirdCardValue == lastCardValue;
    }

    private int getHighCard(Hand hand) {
        return getPointCard(sortedCards(hand).getLast());
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
