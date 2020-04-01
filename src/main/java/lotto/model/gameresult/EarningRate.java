package lotto.model.gameresult;

import java.util.Objects;

public class EarningRate {
    private Double earningRate;

    public EarningRate(Double earningRate) {
        this.earningRate = earningRate;
    }

    public Double getEarningRate() {
        return earningRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EarningRate that = (EarningRate) o;
        return Objects.equals(earningRate, that.earningRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earningRate);
    }
}