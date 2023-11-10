package lotto.domain;

public class LottoPrize {

    private final long amount;
    private final Currency currency;

    public LottoPrize(long amount,
                      Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public long calculateAmount(long value) {
        return this.amount * value;
    }

    @Override
    public String toString() {
        return amount + currency.description();
    }
}
