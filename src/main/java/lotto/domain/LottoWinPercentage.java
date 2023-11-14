package lotto.domain;

import java.util.Objects;

public class LottoWinPercentage {
    private static final double EPSILON = 0.0001;

    private double rate;
    private boolean isLowerStandard;

    public LottoWinPercentage(double rate, boolean isLowerStandard) {
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
        LottoWinPercentage lottoWinPercentage = (LottoWinPercentage) o;
        return Math.abs(rate - lottoWinPercentage.rate) < EPSILON && isLowerStandard == lottoWinPercentage.isLowerStandard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, isLowerStandard);
    }
}
