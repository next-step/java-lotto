package lotto.domain;

public class Money {

    private final int value;

    public Money(final String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        int money = Integer.parseInt(value);

        if (money < 1_000 || 100_000 < money) {
            throw new IllegalArgumentException();
        }
    }
}
