package lotto.util;

import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class RankCalculator {
    private static final int MINIMUM_MONEY_TO_PRINT = 0;

    private RankCalculator() {}

    public static List<String> getRankResult(final List<Rank> lottoResults) {
        return Arrays.stream(Rank.values())
                .filter((rank) -> rank.getWinningMoney() > MINIMUM_MONEY_TO_PRINT)
                .map((rank) -> {
                    int countOfRank = getCountOfRank(lottoResults, rank);
                    return getRankString(rank, countOfRank);
                })
                .collect(Collectors.toList());
    }

    private static int getCountOfRank(final List<Rank> lottoResult, Rank rank) {
        return (int) lottoResult.stream()
                .filter(result -> result == rank)
                .count();
    }

    private static String getRankString(final Rank rank, final int countOfRank) {
        return rank == Rank.SECOND
                ? String.format("%d개 일치 보너스 볼 일치(%d원) - (%d)개", rank.getCountOfMatch(), rank.getWinningMoney(), countOfRank)
                : String.format("%d개 일치 (%d원) - (%d)개", rank.getCountOfMatch(), rank.getWinningMoney(), countOfRank);
    }

    public static BigDecimal getTotalEarningRate(final List<Rank> lottoResults, BigDecimal payMoney) {
        final long winningMoney = lottoResults.stream().mapToLong(Rank::getWinningMoney).sum();
        return BigDecimal.valueOf(winningMoney).divide(payMoney, 3, BigDecimal.ROUND_UP);
    }

}
