package step2.domain;

import java.util.Objects;

public class Statistics {
    private final double profitAmount;
    private static Ranks ranks;

    public Statistics(Lotteries lotteries, Lottery winningNumbers, Number bonusNumber) {
        this.ranks = new Ranks(lotteries, winningNumbers, bonusNumber);
        this.profitAmount = ranks.calculateProfitAmount();
    }

    public Ranks getRanks() {
        return ranks;
    }

    public double calculateProfitRate(double purchaseAmount) {
        return Math.floor(this.profitAmount / purchaseAmount * 100) / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return Double.compare(that.profitAmount, profitAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitAmount);
    }
}
