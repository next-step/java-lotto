package lotto.entity;


import java.math.BigDecimal;
import java.util.List;

public class LottoWinningScanner {

    private LottoWinningScanner() {

    }

    public static LottoResult result(List<Lotto> lottos, Winning winning, int inputMoney) {
        final LottoAnalyzer lottoAnalyzer = new LottoAnalyzer();

        List<WinningResult> analyzer = lottoAnalyzer.analyzer(lottos, winning);
        BigDecimal totalPrizeMoney = RankCalculator.sum(analyzer);
        BigDecimal rate = RankCalculator.calculateRate(inputMoney, totalPrizeMoney);

        return new LottoResult(rate, analyzer);
    }

}
