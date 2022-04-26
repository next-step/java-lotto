package me.devyonghee.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class Score {

    private static final int PROFIT_RATIO_SCALE = 2;
    private static final RoundingMode PROFIT_RATIO_ROUNDING_MODE = RoundingMode.HALF_UP;
    private static final int DEFAULT_COUNT = 0;
    private static final int PLUS_COUNT_SIZE = 1;
    private static final String NULL_RANK_TO_COUNT_ERROR_MESSAGE = "rank to count must not be null";
    private static final String NULL_RANKS_ERROR_MESSAGE = "ranks must not be null";

    private final Collection<Rank> ranks;
    private Map<Rank, Integer> rankToCountCache;

    private Score(Collection<Rank> ranks) {
        Objects.requireNonNull(ranks, NULL_RANKS_ERROR_MESSAGE);
        this.ranks = new ArrayList<>(ranks);
    }

    static Score from(Collection<Rank> ranks) {
        return new Score(ranks);
    }

    public BigDecimal profitRatio() {
        if (ranks.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return profit().divide(purchaseAmount(), PROFIT_RATIO_SCALE, PROFIT_RATIO_ROUNDING_MODE);
    }

    public int count(Rank rank) {
        Objects.requireNonNull(rank, NULL_RANK_TO_COUNT_ERROR_MESSAGE);
        if (rankToCountCache == null) {
            rankToCountCache = rankToCountMap();
        }
        return rankToCountCache.getOrDefault(rank, DEFAULT_COUNT);
    }

    private BigDecimal purchaseAmount() {
        return new BigDecimal(ranks.size() * LottoStore.LOTTO_PRICE);
    }

    private Map<Rank, Integer> rankToCountMap() {
        Map<Rank, Integer> rankToMap = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            rankToMap.merge(rank, PLUS_COUNT_SIZE, Integer::sum);
        }
        return rankToMap;
    }

    private BigDecimal profit() {
        return ranks.stream()
                .map(Rank::prize)
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score = (Score) o;
        return Objects.equals(ranks, score.ranks);
    }
}
