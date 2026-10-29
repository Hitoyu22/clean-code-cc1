import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerTest {

    Poker poker = new Poker();

    @Test
    public void shouldReturnBrelanPoints() {
        Hand hand = new Hand(new Card[] {
                new Card(Color.HEART, 2),
                new Card(Color.SPADE, 2),
                new Card(Color.CLOVER, 2),
                new Card(Color.HEART, 8),
                new Card(Color.DIAMOND, 9)
        });
        List<Hand> hands = new ArrayList<>();
        hands.add(hand);
        int[] points = poker.total(hands);
        int firstHand = points[0];
        assertEquals(30, firstHand);
    }

    @Test
    public void shouldReturnHighCardPoints() {
        Hand brelan = new Hand(new Card[] {
                new Card(Color.HEART, 2),
                new Card(Color.SPADE, 2),
                new Card(Color.CLOVER, 2),
                new Card(Color.HEART, 8),
                new Card(Color.DIAMOND, 9)
        });
        Hand highCard = new Hand(new Card[] {
                new Card(Color.SPADE, 3),
                new Card(Color.HEART, 5),
                new Card(Color.SPADE, 7),
                new Card(Color.CLOVER, 9),
                new Card(Color.DIAMOND, 11)
        });
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
        Hand suite = new Hand(new Card[] {
                new Card(Color.CLOVER, 6),
                new Card(Color.HEART, 4),
                new Card(Color.SPADE, 8),
                new Card(Color.CLOVER, 5),
                new Card(Color.DIAMOND, 7)
        });
        List<Hand> hands = new ArrayList<>();
        hands.add(suite);
        int[] points = poker.total(hands);
        assertEquals(40, points[0]);
    }

    @Test
    public void shouldReturnFullPoints() {
        Hand suite = new Hand(new Card[] {
                new Card(Color.CLOVER, 2),
                new Card(Color.HEART, 2),
                new Card(Color.SPADE, 2),
                new Card(Color.CLOVER, 9),
                new Card(Color.DIAMOND, 9)
        });
        List<Hand> hands = new ArrayList<>();
        hands.add(suite);
        int [] points = poker.total(hands);
        assertEquals(50, points[0]);
    }

    @Test
    void shouldReturnSquarePoints() {
        Hand suite = new Hand(new Card[] {
                new Card(Color.CLOVER, 2),
                new Card(Color.HEART, 2),
                new Card(Color.SPADE, 2),
                new Card(Color.DIAMOND, 2),
                new Card(Color.CLOVER, 9)
        });
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

    @Test
    void shouldReturnQuinteFlushPoints() {
        Hand color = new Hand(new Card[] {
                new Card(Color.HEART, 2),
                new Card(Color.HEART, 3),
                new Card(Color.HEART, 4),
                new Card(Color.HEART, 5),
                new Card(Color.HEART, 6)
        });
        List<Hand> hands = new ArrayList<>();
        hands.add(color);
        int [] points = poker.total(hands);
        assertEquals(80, points[0]);
    }

    @Test
    void shouldReturnTotalPointsOfAllHands() {
        Hand full = new Hand(new Card[] {
                new Card(Color.HEART, 2),
                new Card(Color.SPADE, 2),
                new Card(Color.DIAMOND, 2),
                new Card(Color.CLOVER, 9),
                new Card(Color.SPADE, 9)
        });
        Hand suite = new Hand(new Card[] {
                new Card(Color.CLOVER, 5),
                new Card(Color.DIAMOND, 6),
                new Card(Color.HEART, 7),
                new Card(Color.SPADE, 8),
                new Card(Color.CLOVER, 9)
        });
        Hand color = new Hand(new Card[] {
                new Card(Color.HEART, 2),
                new Card(Color.HEART, 7),
                new Card(Color.HEART, 9),
                new Card(Color.HEART, 11),
                new Card(Color.HEART, 13)
        });
        Hand highCard = new Hand(new Card[] {
                new Card(Color.CLOVER, 3),
                new Card(Color.DIAMOND, 8),
                new Card(Color.HEART, 10),
                new Card(Color.SPADE, 12),
                new Card(Color.CLOVER, 13)
        });
        List<Hand> hands = new ArrayList<>();
        hands.add(full);
        hands.add(suite);
        hands.add(color);
        hands.add(highCard);
        int[] points = poker.total(hands);
        assertEquals(148, Arrays.stream(points).sum());
    }

}
