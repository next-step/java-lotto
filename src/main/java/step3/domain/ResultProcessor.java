package step3.domain;

import step2.domain.LottoMachine;
import java.util.LinkedHashMap;
import java.util.List;

public class ResultProcessor {

    private static final int PRICE_PER_LOTTO = LottoMachine.PRICE_PER_LOTTO;

    public WinningResult result(WinningNumbers winningNumbers, Lottos lottos) {
        List<LottoRank> result = lottos.matchingResult(winningNumbers);
        return new WinningResult(result, earningRate(result, lottos));
    }

    private static double earningRate(List<LottoRank> result, Lottos lottos) {
        return (double) totalEarningMoney(result) / totalPurchasePrice(lottos);
    }

    private static int totalPurchasePrice(Lottos lottos) {
        return lottos.size() * PRICE_PER_LOTTO;
    }

    private static int totalEarningMoney(List<LottoRank> result) {
        return result.stream()
                .mapToInt(LottoRank::winningMoney)
                .sum();
    }
}
