package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningBall;

public class LottoResults {

    private static List<LottoResult> results;

    public static void judge(List<Lotto> lottos, List<WinningBall> winningBalls) {
        WinningCounter winningCounter = new WinningCounter(lottos, winningBalls);
        results = winningCounter.getTotalLottoResult();
    }

    public static List<LottoResult> getResults() {
        return results;
    }
}
