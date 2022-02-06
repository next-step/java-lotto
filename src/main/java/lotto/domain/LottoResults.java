package lotto.domain;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningBall;
import lotto.service.WinningCounter;

public class LottoResults {

    private final List<LottoResult> results;
    private final List<Lotto> lottos;
    private final List<WinningBall> winningBalls;

    public LottoResults(List<Lotto> lottos, List<WinningBall> winningBalls) {
        this.lottos = lottos;
        this.winningBalls = winningBalls;
        this.results = judge();
    }

    public List<LottoResult> judge() {
        WinningCounter winningCounter = new WinningCounter(lottos, winningBalls);
        return winningCounter.getTotalLottoResult();
    }

    public List<LottoResult> getResults() {
        return results;
    }
}
