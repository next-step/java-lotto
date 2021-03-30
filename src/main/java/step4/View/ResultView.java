package step3.View;

import step3.domain.*;

import java.util.Map;

public class ResultView {

    public void printPurchase(Lottos lottos) {
        System.out.println(lottos.getLottoList().size() + "를 구매했습니다.");
    }

    public void printInteger(Lotto lotto) {
        System.out.println(lotto.getLotto());
    }

    public void printSameLotto(Map<Rank, Integer> statistic) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : statistic.keySet()) {
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + ")- "
                    + statistic.get(rank) + "개");
        }
    }
    public void printBenefit(Calculator calculator,Price price) {
        System.out.println("총 수익률은 " + calculator.benefit(price) + "입니다.");
    }

}
