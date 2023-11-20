package study.step3.view;

import java.util.List;

import study.step3.domain.Lotto;
import study.step3.domain.Rank;

public class ResultView {

    public static void show(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void show(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.lottoNumbers()));
        System.out.println();
    }

    public static void showStatisticsTitle() {
        System.out.println("\n당첨 통계\n---------");
    }

    public static void showStatistics(Rank rank, int winningCount) {
        System.out.println(String.format("%d개 일치%s (%d원)- %d개", rank.hitCount(), isBonus(rank), rank.amount(), winningCount));
    }

    private static String isBonus(Rank rank) {
        if (rank.isSecond()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public static void showRevenue(double revenue) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", revenue));
    }
}
