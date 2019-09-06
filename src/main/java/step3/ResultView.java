package step3;

import java.util.Map;
import java.util.Set;

public class ResultView {
    public static void countLottoResult(int countLotto) {
        System.out.println(countLotto + "개를 구매했습니다.");
    }

    public static void printPurchasedLottos(Set<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.lotto);
        }
        printWinningStatistics();
    }

    private static void printWinningStatistics() {
        System.out.println();
    }

    public static void printFinalResult(Map<Integer, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = LottoLottery.MATCHING_LIMIT; i < LottoGenerator.WINNING_NUMBERS_LENGTH + 1; i++) {
            System.out.println(i + "개 일치 (" + Prize.findByCountOfMatch(i).getWinningMoney() + "원)- " + result.get(i) + "개");
        }
    }

    public static void printYield(double yield) {
        double result = yield * 100;
        if (result < 1) {
            System.out.println("총 수익률은 " + result + "입니다. 기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (result >= 1) {
            System.out.printf("총 수익률 1이상!! : 수익률 ");
            System.out.format("%.2f%n", result);
        }
    }
}
