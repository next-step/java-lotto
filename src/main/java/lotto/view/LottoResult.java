package lotto.view;

import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.WinningLotto;
import lotto.view.vo.MatchResult;

public class LottoResult {
    private MatchResult matchResult;

    public LottoResult(WinningLotto winningLotto) {
        matchResult = new MatchResult(winningLotto);
    }

    public MatchResult generate(LottoBundle lottoBundle) {
        matchResult.calculate(lottoBundle);

        return matchResult;
    }

    public double getRewardPercent(int money) {
        double reward = matchResult.calculateTotalReward();

        return reward / money;
    }
}
