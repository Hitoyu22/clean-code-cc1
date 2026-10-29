import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerTest {

    Poker poker = new Poker();

    @Test
    public void shouldReturnBrelanPoints() {

        Hand hand = new Hand(Color.Heart, {2,2,2,8,9});
        List<Hand> hands;
        hands.push(hand);
        int[] points = poker.total(hands);
        int firstHand = points[0];
        assertEquals(30, firstHand);
    }

}
