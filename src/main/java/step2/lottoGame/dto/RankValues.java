package step2.lottoGame.dto;

import step2.lotto.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankValues {

    private final Map<Rank, Long> rankingAggregation;

    public RankValues(Map<Rank, Long> rankingAggregation) {
        this.rankingAggregation = rankingAggregation;
    }

    public List<RankValue> rankValues() {
        return rankingAggregation.entrySet()
                .stream()
                .map(RankValue::from)
                .collect(Collectors.toUnmodifiableList());
    }

}
