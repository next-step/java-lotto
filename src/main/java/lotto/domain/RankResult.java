package lotto.domain;

import lotto.dto.RankResultDto;

import java.util.*;

public class RankResult {

    private final Map<Rank, Long> rankResult;

    public RankResult(Map<Rank, Long> rankResult) {
        this.rankResult = rankResult;
    }

    public Money calculateWinningAmount() {
        return rankResult.entrySet().stream()
                .map(entry -> entry.getKey().getMoney().multiply(entry.getValue()))
                .reduce(new Money(0L), Money::add);
    }

    public double calculateRateOfEarning(Money buyAmount) {
        return calculateWinningAmount().divide(buyAmount);
    }

    public RankResultDto toDto() {
        return new RankResultDto(rankResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankResult rankResult1 = (RankResult) o;
        return Objects.equals(rankResult, rankResult1.rankResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankResult);
    }


}
