package kr.heesu.lotto.domain;

public class LottoStatistics {
    private final MatchResult matches;
    private final PurchaseAmount amount;

    private LottoStatistics(MatchResult matches, PurchaseAmount amount) {
        this.matches = matches;
        this.amount = amount;
    }

    public static LottoStatistics of(MatchResult matches, PurchaseAmount amount) {
        return new LottoStatistics(matches, amount);
    }

    public Long getMatchFrequency(Long match) {
        return this.matches.getMatchFrequency(match);
    }

    public Double getProfitRate() {
        return this.matches.getTotalWinningPrice() / amount.getAmount() * 1.0;
    }

}
