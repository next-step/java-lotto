package study.step4.domain;

import java.util.List;

public class WinningRanks {
    private final static int LOTTO_PRICE_PER_PIECE = 1000;

    private final List<WinningRank> winningRanks;

    public WinningRanks(List<WinningRank> winningRanks) {
        this.winningRanks = winningRanks;
    }

    public long calculateTotalPrize() {
        return winningRanks.stream()
                .mapToLong(WinningRank::getPrizeMoney)
                .sum();
    }

    public double calculateEarningsRate() {
        return calculateTotalPrize() / (double) (winningRanks.size() * LOTTO_PRICE_PER_PIECE);
    }

    public long countRank(WinningRank rank) {
        return winningRanks.stream()
                           .filter(winningRank -> winningRank.equals(rank))
                           .count();
    }
}
