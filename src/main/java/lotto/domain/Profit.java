package lotto.domain;

import java.util.Objects;

public class Profit {
    private int winningPrize;

    public Profit(int winningPrize) {
        this.winningPrize = winningPrize;
    }

    public void accumulate(int matchCount) {
        this.winningPrize += LottoPricing.getByMatchCount(matchCount).getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profit)) return false;
        Profit profit = (Profit) o;
        return winningPrize == profit.winningPrize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningPrize);
    }

    public double calcRate(int cash) {
        return Math.floor((double) this.winningPrize * 100 / cash) / 100.0;
    }

    public String toString(Cash cash) {
        return String.format("총 수익률은 %.2f입니다.", calcRate(cash.getAmount()));
    }
}
