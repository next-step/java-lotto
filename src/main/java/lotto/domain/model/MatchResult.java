package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;


public class MatchResult {
    private final List<Rank> ranks = new ArrayList<>();
    private final LottoNumbers winNumbers;
    private final int bonusNumber;

    MatchResult(LottoNumbers winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getCount(Rank rank) {
        return (int) this.ranks.stream()
                .filter(r -> r == rank)
                .count();
    }

    public double calculateProfit(int purchaseAmount) {
        return (double) getPrize() / purchaseAmount;
    }

    void addRank(LottoNumbers lotto) {
        int matchCount = lotto.countMatch(this.winNumbers);
        boolean matchBonus = lotto.matchBonus(this.bonusNumber);
        this.ranks.add(Rank.valueOf(matchCount, matchBonus));
    }

    private int getPrize() {
        int totalPrize = 0;
        for (Rank rank : this.ranks) {
            totalPrize += rank.getWinningMoney();
        }
        return totalPrize;
    }
}
