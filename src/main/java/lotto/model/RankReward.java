package lotto.model;

import java.util.List;

public class RankReward {

    private List<Rank> winnerLottoNumbers;

    public RankReward(List<Rank> winnerLottoNumbers) {
        this.winnerLottoNumbers = winnerLottoNumbers;
    }

    public int getWinnerCount(int matchingCount) {
        return (int) winnerLottoNumbers
                        .stream()
                        .filter(o -> o.getLottoRank() == matchingCount)
                        .count();
    }

    public int getTotalPrize() {
        return winnerLottoNumbers.stream().mapToInt(Rank::getWinningMoney).sum();
    }


}
