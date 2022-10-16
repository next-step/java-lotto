package lotto.model;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lotto.LottoMatchResult;

public class LottoMatchResults {
    private final List<LottoMatchResult> lottoMatchResults;

    public LottoMatchResults(List<LottoMatchResult> lottoMatchResults) {
        this.lottoMatchResults = lottoMatchResults;
    }

    public Map<LottoReward, List<LottoMatchResult>> rewardableAggregate() {
        return Map.copyOf(collectRewardableToMap());
    }

    private Map<LottoReward, List<LottoMatchResult>> collectRewardableToMap() {
        return lottoMatchResults.stream()
                         .filter(LottoMatchResult::rewardable)
                         .collect(groupingBy(lottoMatchResult -> lottoMatchResult.getLottoReward().get()));
    }

    public int sumRewardAmount() {
        return lottoMatchResults.stream()
                                .filter(LottoMatchResult::rewardable)
                                .map(LottoMatchResult::getLottoReward)
                                .map(Optional::get)
                                .map(LottoReward::getRewardAmount)
                                .reduce(Integer::sum)
                                .orElseGet(() -> 0);
    }
}
