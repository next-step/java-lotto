package lotto.view;

import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.WinningLotto;
import lotto.view.vo.MatchResult;

public class LottoResult {
    private MatchResult matchResult;

    public LottoResult(WinningLotto winningLotto) {
        matchResult = new MatchResult(winningLotto);
    }

    public void generate(LottoBundle lottoBundle) {
        matchResult.calculate(lottoBundle);
        OutputView.printResultStatistics(matchResult);
    }

    public String getRewardPercent(int money) {
        double reward = matchResult.calculateTotalReward();

        double percent = reward / money;
        OutputView.printRewardPercent(percent);

        return String.format("%.2f", percent);
    }
}
