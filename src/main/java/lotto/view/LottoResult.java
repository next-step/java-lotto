package lotto.view;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
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

        System.out.println("당첨통계");
        System.out.println("-------");

        for (Rank rank : Rank.values()) {
            System.out.println(rank.toString() + matchResult.getRank().get(rank));
        }
    }

    public String getRewardPercent(int money) {
        long reward = matchResult.calculateTotalReward();

        double percent = (double) reward / money;

        System.out.println("총 수익률은 " + String.format("%.2f", percent) + "입니다.");
        System.out.println("수익률이 1이면 본전");

        return String.format("%.2f", percent);
    }
}
