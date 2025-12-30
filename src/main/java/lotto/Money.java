package lotto;

public class Money {
    private static final int UNIT_PRICE = 1000;
    private final int amount;

    private Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public int ticketCount() {
        return amount / UNIT_PRICE;
    }

    public int amount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 한다.");
        }
        if (amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 한다.");
        }
    }
}
