package lotto.domain;

public class LottoStatistics {
    private static final int ONE_HUNDRED_INT = 100;
    private static final double ONE_HUNDRED_DOUBLE = 100.0;
    private static final long DEFAULT_TOTAL_AMOUNT = 0L;
    private WinningCounts winningCounts;
    private WinningAmounts winningAmounts;

    public LottoStatistics(WinningCounts winningCounts) {
        this.winningCounts = winningCounts;
        this.winningAmounts = new WinningAmounts();
    }

    public boolean isEmpty() {
        return this.winningCounts.isEmpty();
    }

    public int getCountOfLottoWithMatchingNumber(int matchingNumber) {
        return this.winningCounts.getWinningCount(matchingNumber);
    }

    public long getTotalWinningAmount() {
        long totalAmount = DEFAULT_TOTAL_AMOUNT;
        for (Integer winningNumber : this.winningCounts.getWinningNumberSet()) {
            totalAmount += calculateAmountByWinningNumber(winningNumber);
        }
        return totalAmount;
    }

    public Double calculateRateOfReturnByPrice(Price price) {
        return Math.floor(((double) getTotalWinningAmount() / (double) price.getPrice()) * ONE_HUNDRED_INT)
                / ONE_HUNDRED_DOUBLE;
    }

    private long calculateAmountByWinningNumber(Integer winningNumber) {
        return this.winningCounts.getWinningCount(winningNumber) * this.winningAmounts.getAmount(winningNumber);
    }
}
