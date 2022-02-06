package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningBall;

public class WinningCounter {

    private final List<WinningBall> winningBalls;
    private final List<Lotto> lottos;
    private int count;
    private boolean includeBonus;

    public WinningCounter(List<Lotto> lottos, List<WinningBall> winningBalls) {
        this.lottos = lottos;
        this.winningBalls = winningBalls;
    }

    public List<LottoResult> getTotalLottoResult() {
        final List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            initWinningCountAndBonus();
            lottoResults.add(getLottoResult(lotto));
        }
        return lottoResults;
    }

    private LottoResult getLottoResult(Lotto lotto) {
        for (WinningBall ball : winningBalls) {
            updateWinningCountAndBonus(lotto, ball);
        }

        if (hasToCheckBonus(count)) {
            return LottoResult.of(count, includeBonus);
        }

        return LottoResult.of(count);
    }

    private boolean hasToCheckBonus(int count) {
        return count == 5;
    }

    private void updateWinningCountAndBonus(Lotto lotto, WinningBall ball) {
        if (lotto.getNumbers().getRawNumbers().contains(ball.getNumber())) {
            count++;
            updateIncludeBonus(ball);
        }
    }

    private void updateIncludeBonus(WinningBall ball) {
        if (ball.isBonus()) {
            includeBonus = true;
        }
    }

    private void initWinningCountAndBonus() {
        this.count = 0;
        this.includeBonus = false;
    }
}

