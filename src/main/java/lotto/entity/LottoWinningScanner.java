package lotto.entity;


import java.math.BigDecimal;
import java.util.List;

public class LottoWinningScanner {

    private final LottoResultAnalyzer lottoResultAnalyzer;

    public LottoWinningScanner() {
        this.lottoResultAnalyzer = new LottoResultAnalyzer();
    }

    public LottoResult result(List<Lotto> lottos, List<Integer> winnersNumber, int inputMoney) {

        List<WinningResult> analyzer = lottoResultAnalyzer.analyzer(lottos, winnersNumber);
        BigDecimal totalPrizeMoney = PrizeMoneyCalculator.sum(analyzer);
        BigDecimal rate = PrizeMoneyCalculator.calculateRate(inputMoney, totalPrizeMoney);

        return new LottoResult(rate, analyzer);
    }

}
