package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private List<Rank> ranks;

    public LottoResult(List<RewardStatus> rewardlottos) {
        this.ranks = setWinnerResult(rewardlottos);
    }

    private List<Rank> setWinnerResult(List<RewardStatus> lottoWinerNumbers) {
        return lottoWinerNumbers.stream()
                                .map(i -> Rank.find(i))
                                .collect(Collectors.toList());
    }

    public int getWinnerCount(RewardStatus rewardStatus) {
        return (int) ranks
                .stream()
                .filter(o -> o.equals(Rank.find(rewardStatus))).count();
    }

    public int getTotalPrize() {
        return ranks.stream().mapToInt(Rank::getWinningMoney).sum();
    }



}
