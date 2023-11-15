package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoWinPercentage {
    private static final double EPSILON = 0.0001;

    private double rate;
    private boolean isLowerStandard;

    public LottoWinPercentage(int price, List<LottoWinResult> lottoWinResults) {
        this.rate = calculateRate(price, lottoWinResults);
        this.isLowerStandard = isLowerStandard(rate);
    }

    private double calculateRate(int price, List<LottoWinResult> lottoWinResults) {
        int lottoSum = lottoSum(lottoWinResults);
        return Math.floor((double) lottoSum / price * 100) / 100.0;
    }

    private int lottoSum(List<LottoWinResult> lottoWinResults) {
        int sum = 0;
        for (LottoWinResult lottoWinResult : lottoWinResults) {
            sum += lottoWinResult.income();
        }
        return sum;
    }

    private boolean isLowerStandard(double rate) {
        return rate < 1.0;
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
