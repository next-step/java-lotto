package lotto.domain;

public class LottoResult {

    private final LottoRankRecordBox lottoRankRecordBox;

    public LottoResult(LottoRankRecordBox lottoRankRecordBox) {
        this.lottoRankRecordBox = lottoRankRecordBox;
    }

    public LottoRankRecordBox getLottoRankRecords() {
        return lottoRankRecordBox;
    }

    public double retrieveProfitRatio(int originAmount) {
        double sum = lottoRankRecordBox.retrieveWinPrizeSum();
        return getTwoDecimalPointResult(sum, originAmount);
    }

    static double getTwoDecimalPointResult(double sum, int originAmount) {
        return Math.floor(sum / originAmount * 100) / 100;
    }
}
