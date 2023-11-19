package lotto.view;

import lotto.domain.MatchPoint;
import lotto.domain.MatchPointRank;

public class OutView {

    public static void printResult(int money, MatchPointRank matchPointRank) {
        long totalWinningAmt = 0;

        System.out.println("당첨 통계");
        System.out.println("----");

        for(MatchPoint mp : matchPointRank.getMatchPointSet()) {
            System.out.println(mp.toString() + " " + matchPointRank.getMatchPoint(mp) + "개");
            totalWinningAmt += (mp.getWinningAmt() * matchPointRank.getMatchPoint(mp));
        }

        printRevenueRate(money, totalWinningAmt);
    }

    private static void printRevenueRate(int money, long totalWinningAmount) {
        double revenueRate = Math.floor(((double) totalWinningAmount / money) * 100) / 100;
        System.out.println("총 수익률은 " + revenueRate + "입니다.");
    }
}
