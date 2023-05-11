package lotto.dto;

import lotto.domain.Rank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RankResultDto {
    private final Map<Rank, Long> rankResult;
    public RankResultDto(Map<Rank, Long> rankResult) {
        this.rankResult = new HashMap<>(rankResult);
    }

    public Map<Rank, Long> getRankResult() {
        return Collections.unmodifiableMap(rankResult);
    }
}
