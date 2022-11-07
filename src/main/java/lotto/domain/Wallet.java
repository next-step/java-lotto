package lotto.domain;

public final class Wallet {

    private final Money initialAmount;
    private Money remainingAmount;

    public Wallet(final Money initialAmount) {
        this.initialAmount = initialAmount;
        this.remainingAmount = initialAmount;
    }

    public boolean hasAmount(final Money money) {
        return remainingAmount.isGreaterThanOrEqual(money);
    }

    public Money minusAmount(final Money money) {
        if (!hasAmount(money)) {
            return Money.ZERO;
        }
        remainingAmount = remainingAmount.minus(money);
        return money;
    }

    public Money getUsedAmount() {
        return initialAmount.minus(remainingAmount);
    }

    public int getPurchasableCount(final Money fee) {
        return remainingAmount.divide(fee).intValue();
    }
}
