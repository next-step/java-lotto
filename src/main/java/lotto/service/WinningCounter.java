package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningBall;

public class WinningCounter {

    private final List<WinningBall> winningBalls;
    private final List<Lotto> lottoNumbers;
    private int count;
    private boolean includeBonus;

    public WinningCounter(List<WinningBall> winningBalls) {
        this(new ArrayList<>(), winningBalls);
    }

    public WinningCounter(List<Lotto> lottoNumbers, List<WinningBall> winningBalls) {
        this.lottoNumbers = lottoNumbers;
        this.winningBalls = winningBalls;
    }

    public List<LottoResult> getTotalLottoResult() {
        final List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottoNumbers) {
            initWinningCountAndBonus();
            lottoResults.add(getLottoResult(lotto));
        }
        return lottoResults;
    }

    private LottoResult getLottoResult(Lotto lotto) {
        for (WinningBall ball : winningBalls) {
            updateWinningCountAndBonus(lotto, ball);
        }

        if(hasToCheckBonus(count)) {
            return LottoResult.from(count, includeBonus);
        }

        return LottoResult.from(count);
    }

    private boolean hasToCheckBonus(int count) {
        return count == 5;
    }

    private void updateWinningCountAndBonus(Lotto lotto, WinningBall ball) {
        if (lotto.getNumbers().contains(ball.getNumber())) {
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

