package study.step2.view;

import java.util.List;

import study.step2.domain.Lotto;
import study.step2.domain.dto.Result;

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

    public static void showStatistics(Result result) {
        System.out.println(String.format("%d개 일치 (%d원)- %d개", result.rank().hitCount(), result.rank().amount(), result.winningCount()));
    }

    public static void showRevenue(float revenue) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", revenue));
    }
}
