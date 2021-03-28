package lotto.view;

import lotto.domain.HitCount;
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
            System.out.println(String.format("%s (%,d원)- %d개",
                    makeHitCountMessage(prize.getHitCount()),
                    prize.getPrizeMoney().getHitMoney(),
                    countHitStats.get(prize.name())));
        }
    }

    private String makeHitCountMessage(HitCount hitCount) {
        String message = hitCount.getHitCount() + "개 일치";
        if (hitCount.isHitBonusNumber()) {
            message = message.concat(", 보너스 볼 일치");
        }
        return message;
    }

    private void printReturnRate() {
        System.out.println(String.format("총 수익률은 %s 입니다.", stats.returnRate()));
    }
}
