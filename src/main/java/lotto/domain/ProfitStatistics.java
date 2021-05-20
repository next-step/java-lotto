package lotto.domain;

public class ProfitStatistics {

    private final WinningResults winningResults;
    private final Money input;

    public ProfitStatistics(WinningResults winningResults, Money input) {
        this.winningResults = winningResults;
        this.input = input;
    }

    public double calculateProfitRate() {
        Money totalPrize = winningResults.sumPrizes();
        return totalPrize.divide(input).doubleValue();
    }
}
