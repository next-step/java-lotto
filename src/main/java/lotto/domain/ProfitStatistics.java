package lotto.domain;

public class ProfitStatistics {

    private final WinningResult winningResult;
    private final Money input;

    public ProfitStatistics(WinningResult winningResult, Money input) {
        this.winningResult = winningResult;
        this.input = input;
    }

    public double calculateProfitRate() {
        Money totalPrize = winningResult.sumPrizes();
        return totalPrize.divide(input).doubleValue();
    }
}
