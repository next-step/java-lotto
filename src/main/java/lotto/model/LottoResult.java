package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private List<Rank> rankList;

    public LottoResult(List<RewardStatus> rewardlottos) {
        this.rankList = setWinnerResult(rewardlottos);
    }

    private List<Rank> setWinnerResult(List<RewardStatus> lottoWinerNumbers) {
        return lottoWinerNumbers.stream()
                                .map(i -> Rank.getRankByMatchInfo(i.getMatchingCount(), i.isMatchingBonus()))
                                .collect(Collectors.toList());
    }

    public List<Rank> getLottoResult() {
        return this.rankList;
    }



}
