package lotto.view;

import lotto.Lotto;
import lotto.LottoPricePolicy;
import lotto.Lottos;
import lotto.Number;

import java.util.List;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            System.out.println(lotto);
        }
    }

    public static void printLottosCount(Lottos lottos) {
        System.out.println(lottos.getLottoList().size() + "개를 구매했습니다.");
    }

    public static void printLottosProfit(Lottos lottos, List<Number> winnigList) {
        System.out.println("총 수익률은" + lottos.getProfitRatio(winnigList) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임");
    }

    public static void printStatics(Lottos lottos, List<Number> winnigList) {
        lottos.calculateProfitStatistics(winnigList);

        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (" + LottoPricePolicy.THREE_MATCH.getWinningAmount() + ")원 -" + lottos.getNumberCount(Number.createNumber(3)) + "개");
        System.out.println("4개 일치 (" + LottoPricePolicy.FOUR_MATCH.getWinningAmount() + ")원 -" + lottos.getNumberCount(Number.createNumber(4)) + "개");
        System.out.println("5개 일치 (" + LottoPricePolicy.FIVE_MATCH.getWinningAmount() + ")원 -" + lottos.getNumberCount(Number.createNumber(5)) + "개");
        System.out.println("6개 일치 (" + LottoPricePolicy.SIX_MATCH.getWinningAmount() + ")원 -" + lottos.getNumberCount(Number.createNumber(6)) + "개");
    }
}
