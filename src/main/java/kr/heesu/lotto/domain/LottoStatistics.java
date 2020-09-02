package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Rank;

public class LottoStatistics {
    private final RankResult matches;
    private final PurchaseAmount amount;

    private LottoStatistics(RankResult matches, PurchaseAmount amount) {
        this.matches = matches;
        this.amount = amount;
    }

    public static LottoStatistics of(RankResult matches, PurchaseAmount amount) {
        return new LottoStatistics(matches, amount);
    }

    public Long getRankFrequency(Rank rank) {
        return matches.getRankFrequency(rank);
    }

    public Double getProfitRate() {
        return matches.getTotalWinningPrice() / amount.getAmount() * 1.0;
    }

}
