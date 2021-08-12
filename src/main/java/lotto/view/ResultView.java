package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

public class ResultView {
    private static final String ENTER = "\n";

    private ResultView() {
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.value());
    }

    public static void printWinTitle() {
        System.out.println(ENTER + "당첨 통계");
        System.out.println("---------");
    }

    public static void printRankCount(Rank rank, int count) {
        System.out.printf(String.format("%d개 일치 (%d원)- %d개 \n", rank.getMatch(), rank.getRewards(), count));
    }

    public static void printProfit(double calculateProfit) {
        System.out.print("총 수익률은 " + Math.round(calculateProfit * 100) / 100.0 + " 입니다. ");
        if (calculateProfit < 1) System.out.println("기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
