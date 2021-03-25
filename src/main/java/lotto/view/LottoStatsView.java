package lotto.view;

import lotto.domain.Prize;
import lotto.domain.Stats;

import java.util.Map;

public class LottoStatsView {
    private final Stats stats;

    public LottoStatsView(final Stats stats) {
        printHeader();
        this.stats = stats;
    }

    private void printHeader() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printLottoResult() {
        printHitStats();
        printReturnRate();
    }

    private void printHitStats() {
        Map<String, Integer> countHitStats = stats.countHitStats();

        for (Prize prize : Prize.values()) {
            System.out.println(prize.getHitCount() + "개 일치 (" + prize.getPrizeMoney() + "원)-" + countHitStats.get(prize.name()) + "개");
        }
    }

    private void printReturnRate() {
        System.out.println("총 수익률은 " + stats.returnRate() + "입니다.");
    }
}
