package lotto.view;

import lotto.enums.Rank;
import lotto.view.vo.MatchResult;

public class OutputView {

    public static void printResultStatistics(MatchResult matchResult) {
        System.out.println("당첨통계");
        System.out.println("-------");

        for (Rank rank : Rank.values()) {
            System.out.println(rank.toString() + matchResult.getRanks().get(rank));
        }
    }

    public static void printRewardPercent(double percent) {
        System.out.println("총 수익률은 " + String.format("%.2f", percent) + "입니다.");
        System.out.println("수익률이 1이면 본전");
    }
}
