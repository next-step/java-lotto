package step3.domain.lotto;

public class LottoStatistics {

    public static Profit calculateLottoProfit(LottoMatch lottoMatch, int lottoCount) {
        return Profit.calcLottoProfit(lottoMatch.sumMoney(), lottoCount);
    }


}
