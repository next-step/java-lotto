package lotto.domain;

import lotto.domain.rankcount.RankCountGroup;

import java.util.Arrays;

import static lotto.domain.lotto.LotteryRank.*;

public class ProfitCalculator {

    public double calculateProfitRate(long purchase, RankCountGroup rankCountGroup) {
        return Math.round(((double) calculateTotalPrize(rankCountGroup) /purchase) * 100.0) / 100.0;
    }

    private long calculateTotalPrize(RankCountGroup rankCountGroup) {
        return Arrays.stream(values())
            .mapToLong(rank -> rank.prize() * rankCountGroup.findWinningCountBy(rank))
            .sum();
    }
}
