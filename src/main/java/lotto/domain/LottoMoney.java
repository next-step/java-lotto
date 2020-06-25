package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoMoney {
    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);

    private final BigDecimal amount;

    public LottoMoney(BigDecimal amount) {
        if (!isValid(amount)) {
            throw new IllegalArgumentException();
        }
        this.amount = amount;
    }

    private boolean isValid(final BigDecimal lottoMoney) {
        return (lottoMoney.remainder(LOTTO_PRICE).intValue() == 0) && (lottoMoney.compareTo(LOTTO_PRICE) >= 0);
    }

    public int getNumberOfLottoByMoneyPaid() {
        return this.amount.divide(LOTTO_PRICE, RoundingMode.DOWN).intValue();
    }

}
