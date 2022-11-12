package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Profit {
    public static final int LOTTO_PRICE = 1_000;
    private static final RoundingMode HALF_EVEN = RoundingMode.HALF_EVEN;
    private static final int SCALE = 2;
    private final int lottoQuantity;

    public Profit(int lottoQuantity) {
        this.lottoQuantity = lottoQuantity;
    }

    public BigDecimal calculate(MatchingCollection matchingCollection) {
        BigDecimal sum = matchingCollection.calculateBenefit();

        if (isZeroMoney(sum)) {
            return BigDecimal.ZERO;
        }

        return calculateRevenue(sum);
    }

    public BigDecimal calculateRevenue(BigDecimal sum) {
        return sum.divide(BigDecimal.valueOf((long) lottoQuantity * LOTTO_PRICE),
                SCALE, HALF_EVEN);
    }

    private boolean isZeroMoney(BigDecimal sum) {
        return sum.equals(BigDecimal.valueOf(0.0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profit profit = (Profit) o;
        return lottoQuantity == profit.lottoQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoQuantity);
    }
}
