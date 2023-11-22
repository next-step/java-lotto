package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.MatchPoint;
import lotto.domain.MatchPointRank;

import java.util.List;

public class OutView {

    public static void printResult(int money, MatchPointRank matchPointRank) {
        long totalWinningAmt = 0;

        System.out.println("당첨 통계");
        System.out.println("----");

        for(MatchPoint mp : matchPointRank.getMatchPointSet()) {
            System.out.println(printMatchPoint(mp) + " " + matchPointRank.getMatchPoint(mp) + "개");
            totalWinningAmt += (mp.getWinningAmt() * matchPointRank.getMatchPoint(mp));
        }

        printRevenueRate(money, totalWinningAmt);
    }


    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    private static void printRevenueRate(int money, long totalWinningAmount) {
        double revenueRate = Math.floor(((double) totalWinningAmount / money) * 100) / 100;
        System.out.println("총 수익률은 " + revenueRate + "입니다.");
    }

    public static String printMatchPoint(MatchPoint matchPoint) {
        if(matchPoint == MatchPoint.FIFTH_BONUS) {
            return matchPoint.getMatch() + "개 일치, 보너스 볼 일치" + "(" + matchPoint.getWinningAmt() + "원)-";
        }
        return matchPoint.getMatch() + "개 일치" + "(" + matchPoint.getWinningAmt() + "원)-";
    }
}
