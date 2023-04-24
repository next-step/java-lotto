package lotto.domain;

import java.util.Map;
import java.util.Objects;
import lotto.domain.WinningNumbers.Rank;

public class WinningPercent {

    double winningPercent;

    public WinningPercent(double winningPercent) {
        this.winningPercent = winningPercent;
    }

    public static WinningPercent winningPercent(Map<Rank, Integer> result, int amount) {
        double winningPercent = 0.0d;
        for (Rank rank : result.keySet()) {
            winningPercent += amountSumPerRank(rankCount(result, rank), rankAmount(rank));
        }
        return new WinningPercent(winningPercent / amount);
    }

    private static int rankAmount(Rank rank) {
        return rank.amount();
    }

    private static int amountSumPerRank(int count, int amount) {
        return count * amount;
    }

    private static Integer rankCount(Map<Rank, Integer> result, Rank rank) {
        return result.get(rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningPercent that = (WinningPercent) o;
        return Double.compare(that.winningPercent, winningPercent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningPercent);
    }

    public double value() {
        return winningPercent;
    }

}
