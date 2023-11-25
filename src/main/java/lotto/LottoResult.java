package lotto;

public class LottoResult {
    private final double rateOfReturn;
    private final LottoMatchResult lottoMatchResult;

    public LottoResult(double rateOfReturn, LottoMatchResult lottoMatchResult) {
        this.rateOfReturn = rateOfReturn;
        this.lottoMatchResult = lottoMatchResult;
    }

    public double rateOfReturn() {
        return this.rateOfReturn;
    }

    public LottoMatchResult lottoMatchResult() {
        return this.lottoMatchResult;
    }
}
