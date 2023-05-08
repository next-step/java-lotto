package lotto.domain;

public class Money {

    private final long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        validateUnderZero(amount);
        return new Money(amount);
    }

    public Money minus(Money amount) {
        validateMinusUnderZero(this.amount);
        validateMinusUnderZero(amount.amount);

        return new Money(this.amount - amount.amount);
    }

    public boolean isGreaterThan(Money money) {

        return amount >= money.amount;
    }

    public long getAmount() {
        return amount;
    }

    private static void validateUnderZero(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액을 확인해주세요 :(");
        }
    }

    private static void validateMinusUnderZero(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("0원 이하를 뺼수 없어요 :(");
        }
    }
}

