package lotto.view;

import lotto.domain.*;

import java.util.Set;

public class ResultView {

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.of()) {
            System.out.println(lotto.getAutoLotto());
        }
    }

    public void printResult(Ranks ranks, double profit) {
        System.out.println("당첨 통계");
        System.out.println("-----------------");

        for (Reward Reward : Reward.values()) {
            if (Reward == Reward.MISS) {
                continue;
            }
            printReward(Reward, ranks.of());
        }
        printProfit(profit);
    }

    private void printReward(Reward reward, Set<Rank> rank) {
        System.out.printf("%s개 일치 (%s원)- %s개\n",
                reward.getMatchingCount(),
                reward.getReward(),
                rank.stream().filter(rank1 -> rank1.isMatching(reward.getMatchingCount()))
                        .findFirst()
                        .orElse(new Rank(0))
                        .getMatchingLottosCount());
    }

    private void printProfit(double profit) {
        System.out.printf("총 수익률은 %.2f입니다.\n", profit);
    }
}
