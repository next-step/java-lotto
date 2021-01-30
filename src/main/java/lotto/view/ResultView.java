package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculation;
import lotto.domain.WinningType;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String PURCHASE_NUMBER_MESSAGE = "개를 구입했습니다.";
    private static final String STATISTIC_HEADER_MESSAGE = "당첨 통계\n----------------";
    private static final String STATISTIC_REVENUE_MESSAGE = "총 수익률은 %f 입니다.";

    public static void printPurchaseNumber(int number) {
        System.out.println(number + PURCHASE_NUMBER_MESSAGE);
    }

    public static void printGenerateLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers().toString());
        }
    }

    public static void printResult(Map<WinningType, Integer> matchResult, int money) {
        System.out.println("");
        System.out.println(STATISTIC_HEADER_MESSAGE);
        System.out.println("3개 일치 (" + WinningType.THREE.getProfit() + "원)- " + matchResult.get(WinningType.THREE) + "개");
        System.out.println("4개 일치 (" + WinningType.FOUR.getProfit() + "원)- " + matchResult.get(WinningType.FOUR) + "개");
        System.out.println("5개 일치 (" + WinningType.FIVE.getProfit() + "원)- " + matchResult.get(WinningType.FIVE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(" + WinningType.FIVE_BONUS.getProfit() + "원)- " + matchResult.get(WinningType.FIVE_BONUS) + "개");
        System.out.println("6개 일치 (" + WinningType.SIX.getProfit() + "원)- " + matchResult.get(WinningType.SIX) + "개");

        float profitRate = LottoCalculation.getProfitRate(matchResult, money);
        System.out.println(String.format(STATISTIC_REVENUE_MESSAGE, profitRate));
    }
}
