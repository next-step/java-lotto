package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottoRank;
import lotto.domain.Prize;

import java.util.Map;


public class ResultView {

    public static void printLottos(Lottos lottos) {

        System.out.printf("%d개를 구매했습니다.", lottos.countPurchasedLottos());
        System.out.println();

        for (Lotto lotto : lottos.purchasedLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printResults(Map<LottoRank, Integer> results, int purchaseAmount) {

        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank prize : LottoRank.values()) {

            System.out.printf("%d개 일치 (%d원) - %d개%n", prize.getMatchCount(), prize.getPrizeAmount(), results.get(prize));
        }

        double profitMargin = new Prize(results).getProfitMargin(purchaseAmount);

        System.out.printf("총 수익률은 %f입니다.", profitMargin);

        if (profitMargin < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

    }
}
