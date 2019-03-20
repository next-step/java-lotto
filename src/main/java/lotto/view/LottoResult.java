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

    public static void printLottos(List<BasicLotto> lottos) {
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public void generate(List<BasicLotto> lottos) {
        matchResult.calculate(lottos);
        OutputView.printResultStatistics(matchResult);
    }

    public String getRewardPercent(int money) {
        long reward = matchResult.calculateTotalReward();

        double percent = (double) reward / money;
        OutputView.printRewardPercent(percent);

        return String.format("%.2f", percent);
    }
}
