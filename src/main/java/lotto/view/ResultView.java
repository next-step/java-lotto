package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Reward;

import java.util.Map;

public class ResultView {

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.of()) {
            System.out.println(lotto.getAutoLotto());
        }
    }

    public void printResult(Map<Integer, Integer> countMap, double profit) {
        System.out.println("당첨 통계");
        System.out.println("-----------------");

        for (Reward Reward : Reward.values()) {
            printReward(Reward, countMap);
        }
        printProfit(profit);
    }

    private void printReward(Reward reward, Map<Integer, Integer> countMap) {
        System.out.printf("%s개 일치 (%s원)- %s개\n",
                reward.getMatchingCount(),
                reward.getReward(),
                countMap.get(reward.getMatchingCount()));
    }

    private void printProfit(double profit) {
        System.out.printf("총 수익률은 %.2f입니다.\n", profit);
    }
}
