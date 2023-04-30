package lotto.domain;

public class Money {
    public static final Integer MINIMUM_PRICE = 1000;

    private final long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        if (isNegativeNumberOrZero(amount)) {
            throw new IllegalArgumentException("1000원 이상 입력해주세 :)");
        }
        return new Money(amount);
    }

    private static boolean isNegativeNumberOrZero(long amount) {
        return amount < MINIMUM_PRICE;
    }


    public Money minus(Money amount) {
        return new Money(this.amount - amount.amount);
    }

    public double division(Money money) {
        return (double) this.amount / money.amount;
    }

    public boolean isGreaterThanZero() {
        return amount > 0;
    }

}

