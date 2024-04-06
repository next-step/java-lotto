package lotto.view;

import lotto.domain.*;

import java.util.Set;

public class ResultView {

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.of()) {
            System.out.println(lotto.getAutoLotto());
        }
    }

    public void printResult(Results results, double profit) {
        System.out.println("당첨 통계");
        System.out.println("-----------------");

        for (Reward Reward : Reward.values()) {
            if (Reward == Reward.MISS) {
                continue;
            }
            printReward(Reward, results);
        }
        printProfit(profit);
    }

    private void printReward(Reward reward, Results results) {
        System.out.printf("%s개 일치 (%s원)- %s개\n",
                reward.getMatchingCount(),
                reward.getReward(),
                results.of().getOrDefault(reward, 0));
    }

    private void printProfit(double profit) {
        System.out.printf("총 수익률은 %.2f입니다.\n", profit);
    }
}
