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

    @Test
    public void shouldReturnSuitePoints() {
        Hand suite = new Hand(Color.CLOVER, new int[]{6,4,8,5,7});
        List<Hand> hands = new ArrayList<>();
        hands.add(suite);
        int[] points = poker.total(hands);
        assertEquals(40, points[0]);
    }

    @Test
    public void shouldReturnFullPoints() {
        Hand suite = new Hand(Color.CLOVER, new int[] {2,2,2,9,9});
        List<Hand> hands = new ArrayList<>();
        hands.add(suite);
        int [] points = poker.total(hands);
        assertEquals(50, points[0]);
    }

    @Test
    void shouldReturnSquarePoints() {
        Hand suite = new Hand(Color.CLOVER, new int[] {2,2,2,2,9});
        List<Hand> hands = new ArrayList<>();
        hands.add(suite);
        int [] points = poker.total(hands);
        assertEquals(60, points[0]);
    }

    @Test
    void shouldReturnColorPoints(){
        Hand color = new Hand(new Card[] {
                new Card(Color.HEART, 2),
                new Card(Color.HEART, 5),
                new Card(Color.HEART, 7),
                new Card(Color.HEART, 9),
                new Card(Color.HEART, 11)
        });
        List<Hand> hands = new ArrayList<>();
        hands.add(color);
        int [] points = poker.total(hands);
        assertEquals(45, points[0]);
    }

}
