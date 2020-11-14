package step2.dto;

public class LottoStatisticsResult {
    private final WinLotteryResult winLotteryResult;
    private final double profitRate;

    public LottoStatisticsResult(final WinLotteryResult winLotteryResult, final double profitRate) {
        this.winLotteryResult = winLotteryResult;
        this.profitRate = profitRate;
    }

    public WinLotteryResult getWinLotteryResult() {
        return winLotteryResult;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
