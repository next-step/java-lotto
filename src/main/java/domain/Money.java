package domain;

public class Money {

    private static final int ONE_GAME_AMOUNT = 1_000;

    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int getGameCount() {
        return amount / ONE_GAME_AMOUNT;
    }

    public Money remain(int size) {
        return new Money(amount - size * ONE_GAME_AMOUNT);
    }
}
