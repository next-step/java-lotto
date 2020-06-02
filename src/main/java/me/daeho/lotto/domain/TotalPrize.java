package me.daeho.lotto.domain;

import java.math.BigDecimal;

public class TotalPrize {
    private final int value;

    private TotalPrize(int value) {
        this.value = value;
    }

    public static TotalPrize of(int value) {
        return new TotalPrize(value);
    }

    public EarningRate earningRate(int lottoAmount) {
        return EarningRate.of(
                BigDecimal.valueOf(value)
                        .divide(BigDecimal.valueOf(lottoAmount), 2, BigDecimal.ROUND_UP)
                        .doubleValue()
        );
    }

    public int value() {
        return value;
    }
}
