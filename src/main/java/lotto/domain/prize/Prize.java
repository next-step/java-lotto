package lotto.domain.prize;

public class Prize {

    private final int prize;
    private final int match;
    private int quantity;

    public Prize(int match, int prize) {
        this.prize = prize;
        this.match = match;
    }

    public int compute() {
        return prize * quantity;
    }

    public void add() {
        quantity++;
    }

    public int quantity() {
        return quantity;
    }
}
