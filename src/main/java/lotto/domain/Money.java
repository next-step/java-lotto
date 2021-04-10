package lotto.domain;

public class Money {
    private int won = 0;

    public Money(final int won) {
        this.won = won;
    }

    public int won() {
        return this.won;
    }
}
