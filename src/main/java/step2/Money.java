package step2;

import static util.Preconditions.checkArgument;

public class Money {
    public static final String MONEY_MUST_NOT_BE_NEGATIVE = "money must not be negative";
    public static final String MONEY_MUST_BE_DIVIDED = "money must be divided";
    private int value;

    private Money(final int money) {
        this.value = money;
    }

    public static Money of(int money) {
        checkArgument(money >= 0, MONEY_MUST_NOT_BE_NEGATIVE);
        return new Money(money);
    }

    public int divide(final Money money) {
        checkArgument(isDivided(money), MONEY_MUST_BE_DIVIDED);
        return value / money.value;
    }

    private boolean isDivided(final Money money) {
        return value % money.value == 0;
    }
}
