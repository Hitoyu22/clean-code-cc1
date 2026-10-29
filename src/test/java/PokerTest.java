import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerTest {

    Poker poker = new Poker();

    @Test
    public void shouldReturnBrelanPoints() {
        Hand hand = new Hand(Color.HEART, new int[]{2,2,2,8,9});
        List<Hand> hands = new ArrayList<>();
        hands.add(hand);
        int[] points = poker.total(hands);
        int firstHand = points[0];
        assertEquals(30, firstHand);
    }

    @Test
    public void shouldReturnHighCardPoints() {
        Hand brelan = new Hand(Color.HEART, new int[]{2,2,2,8,9});
        Hand highCard = new Hand(Color.SPADE, new int[]{3,5,7,9,11});
        List<Hand> hands = new ArrayList<>();
        hands.add(brelan);
        hands.add(highCard);
        int[] points = poker.total(hands);
        assertEquals(2, points.length);
        assertEquals(30, points[0]);
        assertEquals(11, points[1]);
    }

}
