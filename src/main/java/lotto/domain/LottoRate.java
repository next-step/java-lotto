package lotto.domain;

import java.util.Objects;

public class LottoRate {
    private static final double EPSILON = 0.0001;

    private double rate;
    private boolean isLowerStandard;

    public LottoRate(double rate, boolean isLowerStandard) {
        this.rate = rate;
        this.isLowerStandard = isLowerStandard;
    }

    public double getRate() {
        return rate;
    }

    public boolean isLowerStandard() {
        return isLowerStandard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoRate lottoRate = (LottoRate) o;
        return Math.abs(rate - lottoRate.rate) < EPSILON && isLowerStandard == lottoRate.isLowerStandard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, isLowerStandard);
    }
}
