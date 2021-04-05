package lotto.view;

import lotto.domain.HitCount;
import lotto.domain.HitResults;
import lotto.domain.Money;
import lotto.domain.Prize;

public class HitResultView {
    private final HitResults hitResults;
    private final Money payMoney;

    public HitResultView(final HitResults hitResults, Money payMoney) {
        printHeader();
        this.hitResults = hitResults;
        this.payMoney = payMoney;
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
        for (Prize prize : Prize.values()) {
            System.out.printf("%s (%,d원)- %d개%n",
                    makeHitCountMessage(prize.getHitCount()),
                    prize.prizeMoney(),
                    hitResults.countPrize(prize));
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
        System.out.printf("총 수익률은 %s 입니다.%n", hitResults.returnRate(payMoney));
    }
}
