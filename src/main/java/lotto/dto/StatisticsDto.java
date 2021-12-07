package lotto.dto;

import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.List;

public class StatisticsDto {
    private List<Rank> ranks;
    private int buyRound;

    public StatisticsDto(List<Rank> ranks, int buyRound) {
        this.ranks = ranks;
        this.buyRound = buyRound;
    }

    public long countRank(Rank rank) {
        return ranks.stream()
                .filter(rankType -> rankType.equals(rank))
                .count();
    }

    public BigDecimal earningRate() {
        BigDecimal amount = BigDecimal.ZERO;
        for (Rank rank : ranks) {
            amount = amount.add(BigDecimal.valueOf(rank.getWinningMoney()));
        }
        return amount.divide(BigDecimal.valueOf(buyRound * 1000), 2, BigDecimal.ROUND_CEILING);
    }
}
