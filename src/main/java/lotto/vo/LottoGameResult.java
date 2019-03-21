package lotto.vo;

public class LottoGameResult {
    private final LottoWinResult lottoWinResult;
    private final LottoProfit lottoProfit;

    public LottoGameResult(LottoWinResult lottoWinResult) {
        this.lottoWinResult = lottoWinResult;
        this.lottoProfit = new LottoProfit(lottoWinResult);
    }

    public LottoWinResult getLottoWinResult() {
        return this.lottoWinResult;
    }

    public long getTotalPrizeMoney() {
        return this.lottoProfit.getTotalPrizeMoney();
    }

    public double getTotalProfitRate() {
        return this.lottoProfit.getTotalProfitRate();
    }
}
