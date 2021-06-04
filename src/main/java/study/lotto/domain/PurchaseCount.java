package study.lotto.domain;

import study.lotto.exception.WrongSelfPickCountException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PurchaseCount {
    public static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);

    private final int purchaseCount;

    private PurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public PurchaseCount(BigDecimal amount) {
        this(amount.divide(LOTTO_PRICE,0, RoundingMode.DOWN).intValue());
    }

    public int value() {
        return purchaseCount;
    }

    public void isaAvailable(int selfPickLottoCount) {
        if (purchaseCount < selfPickLottoCount) {
            throw new WrongSelfPickCountException();
        }
    }

    public int availableCount(int selfPickCount) {
        return purchaseCount - selfPickCount;
    }
}
