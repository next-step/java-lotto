package step2;

public class LottoStatisticsResult {
    private final WinLotteryResult winLotteryResult;
    private final double profitRate;

    public LottoStatisticsResult(final WinLotteryResult winLotteryResult, final double profitRate) {
        this.winLotteryResult = winLotteryResult;
        this.profitRate = profitRate;
    }
}
