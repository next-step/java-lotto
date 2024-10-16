package lotto.entity;


import java.math.BigDecimal;
import java.util.List;

public class LottoWinningScanner {

    private final LottoResultAnalyzer lottoResultAnalyzer;

    public LottoWinningScanner() {
        this.lottoResultAnalyzer = new LottoResultAnalyzer();
    }

    public LottoResult result(List<Lotto> lottos, Winning winning, int inputMoney) {

        List<WinningResult> analyzer = lottoResultAnalyzer.analyzer(lottos, winning);
        BigDecimal totalPrizeMoney = RankCalculator.sum(analyzer);
        BigDecimal rate = RankCalculator.calculateRate(inputMoney, totalPrizeMoney);

        return new LottoResult(rate, analyzer);
    }

}
