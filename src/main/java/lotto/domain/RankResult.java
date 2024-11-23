package lotto.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class RankResult {

    public static final int ZERO = 0;

    private final Map<Rank, Integer> rankFrequency;

    public RankResult(Map<Rank, Integer> rankFrequency) {
        validateKey(rankFrequency);
        validateValue(rankFrequency);

        this.rankFrequency = rankFrequency;
    }

    private void validateKey(Map<Rank, Integer> rankFrequency) {
        Set<Rank> keySet = rankFrequency.keySet();
        boolean hasAllRanks = keySet.containsAll(Arrays.asList(Rank.values()));

        if (!hasAllRanks) {
            throw new IllegalArgumentException("모든 등수의 결과가 포함되어야 합니다.");
        }
    }

    private void validateValue(Map<Rank, Integer> rankFrequency) {
        Collection<Integer> values = rankFrequency.values();
        values.forEach((value -> {
            if (value < ZERO) {
                throw new IllegalArgumentException("빈도는 음수일 수 없습니다.");
            }
        }));
    }

    public Integer of(Rank rank) {
        return rankFrequency.get(rank);
    }
}
