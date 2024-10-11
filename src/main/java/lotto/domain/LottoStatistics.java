package lotto.domain;

public class LottoStatistics {
    private final Money money;
    private final LottoWinningResults winningResults;

    public LottoStatistics(final Money money, final LottoWinningResults winningResults) {
        this.money = money;
        this.winningResults = winningResults;
    }

    public double rate() {
        return money.calculateRate(winningResults.totalWinningPrice());
    }
}
