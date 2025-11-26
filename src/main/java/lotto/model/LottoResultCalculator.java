package lotto.model;

public class LottoResultCalculator {
    public static LottoResults calculate(Lottos lottos, WinningLotto winningLotto) {
        LottoResults lottoResults = new LottoResults();
        for (Lotto lotto : lottos.lottos()) {
            lottoResults.update(winningLotto.calculatePrize(lotto));
        }
        return lottoResults;
    }
}
