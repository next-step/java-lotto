package lotto.dto;

import java.util.List;
import java.util.Map;

import lotto.LottoMatchResult;
import lotto.model.LottoReward;

public class LottoResultAggregation {
    private static final int NO_MATCH = 0;
    private final Map<LottoReward, List<LottoMatchResult>> rewardAndCountMaps;

    public LottoResultAggregation(Map<LottoReward, List<LottoMatchResult>> rewardAndCountMaps) {
        this.rewardAndCountMaps = rewardAndCountMaps;
    }

    public int rewardMatchCount(LottoReward lottoReward) {
        if (rewardAndCountMaps.containsKey(lottoReward)) {
            return rewardAndCountMaps.get(lottoReward).size();
        }

        return NO_MATCH;
    }
}
