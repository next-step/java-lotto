package lotto.domain;

import java.math.BigDecimal;

public class LottoPrize {

    private final BigDecimal amount;
    private final Currency currency;

    public LottoPrize(BigDecimal amount,
                      Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public long calculateAmount(long value) {
        return this.amount.multiply(BigDecimal.valueOf(value)).longValue();
    }

    @Override
    public String toString() {
        return amount + currency.description();
    }
}
