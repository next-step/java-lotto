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

    public Money minus(Money money) {
        validateMinusUnderZero(this.amount);
        validateMinusUnderZero(money.amount);

        return new Money(this.amount - money.amount);
    }

    public boolean isGreaterThan(Money money) {

        return this.amount >= money.amount;
    }

    public Money times(int count) {

        long multiplyAmount = Math.multiplyExact(this.amount, count);
        return new Money(multiplyAmount);
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

