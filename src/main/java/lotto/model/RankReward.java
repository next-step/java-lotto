package lotto.model;

import java.util.List;

public class RankReward {

    private List<Rank> rankList;

    public RankReward(List<Rank> rankList) {
        this.rankList = rankList;
    }

    public int getWinnerCount(int matchingCount) {
        return (int) rankList
                        .stream()
                        .filter(o -> o.getLottoRank() == matchingCount)
                        .count();
    }

    public int getTotalPrize() {
        return rankList.stream().mapToInt(Rank::getWinningMoney).sum();
    }


}
