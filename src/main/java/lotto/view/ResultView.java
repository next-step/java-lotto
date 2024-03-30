package lotto.view;

import lotto.constants.Const;
import lotto.domain.Reward;

import java.util.Map;

public class ResultView {

    public void printResult(Map<Integer, Integer> countMap, double profit) {
        System.out.println(Const.RESULT);
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
