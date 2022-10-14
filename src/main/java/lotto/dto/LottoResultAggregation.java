package lotto.dto;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

import lotto.LottoMatchResult;
import lotto.model.LottoReward;

public class LottoResultAggregation {
    private final Map<LottoReward, List<LottoMatchResult>> rewardAndCountMaps;

    public LottoResultAggregation(List<LottoMatchResult> lottoMatchResults) {
        this.rewardAndCountMaps = lottoMatchResults.stream()
                                                   .filter(LottoMatchResult::rewardable)
                                                   .collect(groupingBy(lottoMatchResult -> lottoMatchResult.getLottoReward().get()));
    }

    public int getCount(LottoReward lottoReward) {
        return rewardAndCountMaps.get(lottoReward).size();
    }
}
