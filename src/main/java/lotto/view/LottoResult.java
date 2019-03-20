package lotto.view;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.view.vo.MatchResult;

import java.util.List;

public class LottoResult {
    private MatchResult matchResult;

    public LottoResult(WinningLotto winningLotto) {
        matchResult = new MatchResult(winningLotto);
    }

    public void generate(List<BasicLotto> lottos) {
        matchResult.calculate(lottos);
        OutputView.printResultStatistics(matchResult);
    }

    public String getRewardPercent(int money) {
        double reward = matchResult.calculateTotalReward();

        double percent = reward / money;
        OutputView.printRewardPercent(percent);

        return String.format("%.2f", percent);
    }
}
