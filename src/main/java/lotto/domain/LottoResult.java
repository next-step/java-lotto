package lotto.domain;

public class LottoResult {

    private final WinningCount manualWinningCount;

    private final WinningCount autoWinningCount;

    public LottoResult(LottoChecker lottoChecker, Lottoes manualLottoes,
                       Lottoes autoLottoes) {
        this.manualWinningCount = lottoChecker.countWinningLottoes(manualLottoes);
        this.autoWinningCount = lottoChecker.countWinningLottoes(autoLottoes);
    }

    public WinningCount getManualWinningCount() {
        return manualWinningCount;
    }

    public WinningCount getAutoWinningCount() {
        return autoWinningCount;
    }

    public double calculateEarn(int paid) {
        long manualPrize = manualWinningCount.calculatePrize();
        long autoPrize = autoWinningCount.calculatePrize();
        long totalPrize = manualPrize + autoPrize;

        return (double) totalPrize / paid;
    }
}
