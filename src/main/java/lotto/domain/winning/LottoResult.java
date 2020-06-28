package lotto.domain.winning;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private static final int MINIMUM_MONEY_TO_PRINT = 0;

    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public List<String> getRankResult() {
        return Arrays.stream(Rank.values())
                .filter((rank) -> rank.getWinningMoney() > MINIMUM_MONEY_TO_PRINT)
                .map((rank) -> {
                    int countOfRank = getCountOfRank(ranks, rank);
                    return getRankString(rank, countOfRank);
                })
                .collect(Collectors.toList());
    }

    private static int getCountOfRank(final List<Rank> ranks, Rank rank) {
        return (int) ranks.stream()
                .filter(result -> result == rank)
                .count();
    }

    private static String getRankString(final Rank rank, final int countOfRank) {
        return rank == Rank.SECOND
                ? String.format("%d개 일치 보너스 볼 일치(%d원) - (%d)개", rank.getCountOfMatch(), rank.getWinningMoney(), countOfRank)
                : String.format("%d개 일치 (%d원) - (%d)개", rank.getCountOfMatch(), rank.getWinningMoney(), countOfRank);
    }

    public BigDecimal getTotalEarningRate(final BigDecimal payMoney) {
        final long winningMoney = ranks.stream().mapToLong(Rank::getWinningMoney).sum();
        return BigDecimal.valueOf(winningMoney).divide(payMoney, 3, BigDecimal.ROUND_UP);
    }

}
