package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class RankResult {
    private static final Long ZERO = 0L;

    private final Map<Rank, Long> result;

    private RankResult(Map<Rank, Long> result) {
        this.result = result;
    }

    public static RankResult of(Map<Rank, Long> matches) {
        Map<Rank, Long> result = initializeResultMap(matches);
        return new RankResult(result);
    }

    private static Map<Rank, Long> initializeResultMap(Map<Rank, Long> matches) {
        Map<Rank, Long> result = new HashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, ZERO);
        }
        for (Map.Entry<Rank, Long> entry : matches.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public Long getTotalWinningPrice() {
        return Stream.of(Rank.values())
                .mapToLong(rank -> result.get(rank) * rank.getWinningMoney())
                .sum();
    }

    public Long getRankFrequency(Rank rank) {
        return result.get(rank);
    }
}
