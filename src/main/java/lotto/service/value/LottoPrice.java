package lotto.service.value;

import lotto.utils.Preconditions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static lotto.rule.LottoRule.MINIMUM_PRICE;

public class LottoPrice {
    private static final Integer YIELD_SCALE = 2;
    private final BigDecimal purchasePrice;

    private LottoPrice(Integer purchasePrice) {
        Preconditions.checkNotNull(purchasePrice, "price 필수값 입니다.");

        this.purchasePrice = BigDecimal.valueOf(purchasePrice);
    }

    public static LottoPrice from(Integer purchasePrice) {
        return new LottoPrice(purchasePrice);
    }

    public Integer getLottoQuantity() {
        return purchasePrice.intValue() / MINIMUM_PRICE;
    }

    public BigDecimal getYield(BigDecimal winningMoney) {
        return winningMoney.divide(purchasePrice, YIELD_SCALE, RoundingMode.DOWN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrice lottoPrice1 = (LottoPrice) o;
        return Objects.equals(purchasePrice, lottoPrice1.purchasePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasePrice);
    }
}
