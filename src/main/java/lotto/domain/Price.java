package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Price {

    private static final int LOTTO_PRICE = 1000;

    private final int buyPrice;

    public Price(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int countBuySum() {
        return BigDecimal.valueOf(buyPrice)
            .divide(BigDecimal.valueOf(LOTTO_PRICE), RoundingMode.DOWN).intValue();
    }

    public int calculateAutoBuyCount(int manualBuyCount) {
        return countBuySum() - manualBuyCount;
    }

    public int getBuyPrice() {
        return buyPrice;
    }
}
