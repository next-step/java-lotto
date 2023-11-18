package lotto.dto;

import lotto.constants.Winning;

import java.util.List;
import java.util.Objects;

public class Summary {
    private final long firstCount;
    private final long secondCount;
    private final long thirdCount;
    private final long fourthCount;
    private final long fifthCount;
    private final float profitRate;

    public Summary(long firstCount, long secondCount, long thirdCount, long fourthCount, long fifthCount, float profitRate) {
        this.firstCount = firstCount;
        this.secondCount = secondCount;
        this.thirdCount = thirdCount;
        this.fourthCount = fourthCount;
        this.fifthCount = fifthCount;
        this.profitRate = profitRate;
    }

    public Summary(List<Winning> winnings, Long purchasePrice) {
        this.firstCount = winningCount(winnings, Winning.FIRST);
        this.secondCount = winningCount(winnings, Winning.SECOND);
        this.thirdCount = winningCount(winnings, Winning.THIRD);
        this.fourthCount = winningCount(winnings, Winning.FOURTH);
        this.fifthCount = winningCount(winnings, Winning.FIFTH);
        this.profitRate = profitRate(winnings, purchasePrice);
    }

    private long winningCount(List<Winning> winnings, Winning winning) {
        return winnings.stream()
                .filter(winning::equals)
                .count();
    }

    private float profitRate(List<Winning> winnings, long purchasePrice) {
        return (float) prizeTotal(winnings) / (float) purchasePrice;
    }

    private long prizeTotal(List<Winning> winnings) {
        return winnings.stream()
                .mapToLong(Winning::prize)
                .sum();
    }

    public long firstCount() {
        return firstCount;
    }

    public long secondCount() {
        return secondCount;
    }

    public long thirdCount() {
        return thirdCount;
    }

    public long fourthCount() {
        return fourthCount;
    }

    public long fifthCount() {
        return fifthCount;
    }

    public float profitRate() {
        return profitRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return firstCount == summary.firstCount && secondCount == summary.secondCount && thirdCount == summary.thirdCount && fourthCount == summary.fourthCount && fifthCount == summary.fifthCount && Float.compare(profitRate, summary.profitRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCount, secondCount, thirdCount, fourthCount, fifthCount, profitRate);
    }

    @Override
    public String toString() {
        return "Summary{" +
                "firstCount=" + firstCount +
                ", secondCount=" + secondCount +
                ", thirdCount=" + thirdCount +
                ", fourthCount=" + fourthCount +
                ", fifthCount=" + fifthCount +
                ", profitRate=" + profitRate +
                '}';
    }
}
