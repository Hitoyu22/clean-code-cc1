import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Poker {

    private static final int BRELAN_POINTS = 30;
    private static final int SUITE_POINTS = 40;
    private static final int FULL_POINTS = 50;
    private static final int SQUARE_POINTS = 60;
    private static final int COLOR_POINTS = 45;
    private static final int QUINTE_FLUSH_POINTS = 80;

    public int[] total(List<Hand> hands) {
        int[] points = new int[hands.size()];
        for (int i = 0; i < hands.size(); i++) {
            points[i] = points(hands.get(i));
        }
        return points;
    }

    private int points(Hand hand) {
        return switch (hand) {
            case Hand h when isQuinteFlush(h) -> QUINTE_FLUSH_POINTS;
            case Hand h when isSuite(h) -> SUITE_POINTS;
            case Hand h when isFull(h) -> FULL_POINTS;
            case Hand h when isSquare(h) -> SQUARE_POINTS;
            case Hand h when isColor(h) -> COLOR_POINTS;
            case Hand h when isBrelan(h) -> BRELAN_POINTS;
            default -> getHighCard(hand);
        };
    }

    private boolean isFull(Hand hand) {
        if (!isBrelan(hand)) {
            return false;
        }

        List<Card> cards = sortedCards(hand);
        int firstCardValue = getPointCard(cards.getFirst());
        int secondCardValue = getPointCard(cards.get(1));
        int fourthCardValue = getPointCard(cards.get(3));
        int lastCardValue = getPointCard(cards.getLast());

        return firstCardValue == secondCardValue && fourthCardValue == lastCardValue;
    }

    private boolean isQuinteFlush(Hand hand) {
        return isSuite(hand) && isColor(hand);
    }

    private boolean isSquare(Hand hand) {
        if (!isBrelan(hand)) {
            return false;
        }

        List<Card> cards = sortedCards(hand);

        int firstCardValue = getPointCard(cards.getFirst());
        int secondCardValue = getPointCard(cards.get(1));
        int fourthCardValue = getPointCard(cards.get(3));
        int lastCardValue = getPointCard(cards.getLast());

        return firstCardValue == fourthCardValue || secondCardValue == lastCardValue;
    }

    private boolean isColor(Hand hand) {
        List<Card> cards = hand.getCards();
        Color firstCardColor = cards.getFirst().getColor();
        for (Card card : cards) {
            if (card.getColor() != firstCardColor) {
                return false;
            }
        }
        return true;
    }

    private boolean isBrelan(Hand hand) {

        List<Card> cards = sortedCards(hand);
        int firstCardValue = getPointCard(cards.getFirst());
        int thirdCardValue = getPointCard(cards.get(2));
        int lastCardValue = getPointCard(cards.getLast());

        return firstCardValue == thirdCardValue || thirdCardValue == lastCardValue;
    }

    private boolean isSuite(Hand hand) {
        List<Card> cards = sortedCards(hand);
        for (int i = 0; i < cards.size() -1; i++) {
            int actualCardPoint = getPointCard(cards.get(i));
            int nextCardPoint = getPointCard(cards.get(i+1));
            if (nextCardPoint != (actualCardPoint + 1)) {
                return false;
            }
        }
        return true;
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
