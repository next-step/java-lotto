package lotto.domain.lotto;

public class LottosResult {
    private final int[] winningStaticsArray;
    private final double rateOfReturn;

    private LottosResult(int[] winningStaticsArray, double rateOfReturn) {
        this.winningStaticsArray = winningStaticsArray;
        this.rateOfReturn = rateOfReturn;
    }

    public static LottosResult newLottoResult(int[] winningStaticsArray, double rateOfReturn) {
        return new LottosResult(winningStaticsArray, rateOfReturn);
    }

    public int winningStatic(int matchCount) {
        return winningStaticsArray[matchCount];
    }

    public double rateOfReturn() {
        return rateOfReturn;
    }
}
