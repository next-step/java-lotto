package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResults {

    private final List<LottoResult> results;
    private final List<UserLotto> lottos;
    private final List<WinningBall> winningBalls;
    private final Map<UserLotto, WinningInfo> winningInfoOfLotto = new HashMap<>();

    public LottoResults(List<UserLotto> lottos, List<WinningBall> winningBalls) {
        this.lottos = lottos;
        this.winningBalls = winningBalls;
        this.results = judge();
    }

    public List<LottoResult> judge() {
        return lottos.stream()
            .map(this::getLottoResult)
            .collect(Collectors.toList());
    }

    private LottoResult getLottoResult(UserLotto lotto) {
        for (WinningBall ball : winningBalls) {
            updateWinningCountAndBonus(lotto, ball);
        }

        WinningInfo info = winningInfoOfLotto.getOrDefault(lotto, new WinningInfo(0, false));
        return LottoResult.of(info.getCount(), info.isBonus());
    }

    private void updateWinningCountAndBonus(UserLotto lotto, WinningBall ball) {
        WinningInfo info = winningInfoOfLotto.getOrDefault(lotto, new WinningInfo(0, false));

        if (hasWinningNumber(lotto, ball)) {
            info.countUp();
        }

        updateIncludeBonus(lotto, ball, info);
    }

    private boolean hasWinningNumber(UserLotto lotto, WinningBall ball) {
        return lotto.contains(ball.getNumber());
    }

    private void updateIncludeBonus(UserLotto lotto, WinningBall ball, WinningInfo info) {
        if (ball.isBonus()) {
            info.setBonus(true);
        }
        winningInfoOfLotto.put(lotto, info);
    }

    public List<LottoResult> getResults() {
        return results;
    }
}
