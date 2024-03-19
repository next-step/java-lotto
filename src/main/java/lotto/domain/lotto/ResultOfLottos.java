package lotto.domain.lotto;

public class ResultOfLottos {
    private final int[] winningStaticsArray;
    private final double rateOfReturn;

    private ResultOfLottos(int[] winningStaticsArray, double rateOfReturn) {
        this.winningStaticsArray = winningStaticsArray;
        this.rateOfReturn = rateOfReturn;
    }

    public static ResultOfLottos newLottoResult(int[] winningStaticsArray, double rateOfReturn) {
        return new ResultOfLottos(winningStaticsArray, rateOfReturn);
    }

    public int winningStatic(int matchCount) {
        return winningStaticsArray[matchCount];
    }

    public double rateOfReturn() {
        return rateOfReturn;
    }
}
