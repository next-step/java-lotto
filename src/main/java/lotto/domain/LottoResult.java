package lotto.domain;

import java.util.List;

public class LottoResult {
    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public double getTotalWinningMoney() {
        int totalWinningMoney = 0;
        for (Rank rank : ranks) {
            totalWinningMoney += rank.getWinningMoney();
        }
        return totalWinningMoney;
    }
}
