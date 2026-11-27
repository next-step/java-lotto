package view;

import domain.Lotto;
import domain.Rank;
import domain.WinningStatistics;

import java.util.List;

public class ResultView {


    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumberValues());
        }
    }

    public static void printStatistics(WinningStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)) {
            System.out.println(formatRank(rank) + "- " + statistics.countOf(rank) + "개");
        }
    }

    private static String formatRank(Rank rank) {
        if (rank.requiresBonus()) {
            return rank.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + rank.getWinningMoney() + "원) ";
        }
        return rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)";
    }


    public static void printProfitRate(double profitRate) {
        System.out.print("총 수익률은 " + String.format("%.2f", profitRate) + "입니다.");
        if (profitRate < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println();
    }
}