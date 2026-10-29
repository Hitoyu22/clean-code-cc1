import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();

    public Hand(Color color, int[] values) {
        for (int value : values) {
            cards.add(new Card(color, value));
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
