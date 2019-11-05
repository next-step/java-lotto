package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningStatus {

    private final List<Winning> winnings;

    public WinningStatus() {
        this.winnings = Arrays.asList(
                new Winning(Rank.MISS),
                new Winning(Rank.FIFTH),
                new Winning(Rank.FOURTH),
                new Winning(Rank.THIRD),
                new Winning(Rank.SECOND),
                new Winning(Rank.FIRST)
        );
    }

    public void addCountOfRankFor(final Rank rank) {
        winnings.stream()
                .filter(winning -> winning.getRank().equals(rank.name()))
                .forEach(Winning::addCount);
    }

    public int getCountOfRankFor(final Rank rank) {
        return winnings.stream()
                .filter(winning -> winning.getRank().equals(rank.name()))
                .mapToInt(Winning::getCount)
                .findAny()
                .orElse(0);
    }

    public double getTotalWinningAmount() {
        return winnings.stream()
                .mapToDouble(Winning::getWinningAmount)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningStatus that = (WinningStatus) o;
        return Objects.equals(winnings, that.winnings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnings);
    }
}
