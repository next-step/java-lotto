package lotto.domain;

import java.util.Map;

public class WinningRank {

    private final Map<Rank, Long> winningRanks;

    public WinningRank(Map<Rank, Long> winningRanks) {
        this.winningRanks = winningRanks;
    }

    public Money calcTotalWinningPrice() {
        long totalWinningPrice = winningRanks.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().sumWinningPrice(entry.getValue()))
                .sum();

        return new Money(totalWinningPrice);
    }
}
