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

        // 1. 1 ~ 3등을 뺀 나머지 출력
        for (int i = LottoLottery.MATCHING_LIMIT; i < LottoGenerator.BONUS_WINNING_VALID_NUMBER; i++) {

            System.out.println(i + "개 일치 (" + Prize.findByCountOfMatch(i).getWinningMoney() + "원)- " + result.get(i) + "개");
        }

        // 2. 1, 2등을 출력
        for (int i = LottoGenerator.BONUS_WINNING_VALID_NUMBER; i < LottoGenerator.WINNING_NUMBERS_LENGTH + 1; i++) {
            printBonusWinningValidResult(result, i);
        }
    }

    private static void printBonusWinningValidResult(Map<Integer, Integer> result, int i) {
        if (i == LottoGenerator.BONUS_WINNING_VALID_NUMBER) {
            System.out.println(i + "개 일치 (" + Prize.findByCountOfMatch(i).getWinningMoney() + "원)- " + (result.get(i) - LottoLottery.BONUS_WINNING_COUNT) + "개");
        }
        if (i == LottoGenerator.BONUS_WINNING_VALID_NUMBER) {
            System.out.println(i + "개 일치, 보너스 볼 일치 (" + Prize.findByCountOfMatch(i + 1).getWinningMoney() + "원)- " + LottoLottery.BONUS_WINNING_COUNT + "개");
        }
        if (i == LottoGenerator.WINNING_NUMBERS_LENGTH) {
            System.out.println(i + "개 일치 (" + Prize.findByCountOfMatch(i + 1).getWinningMoney() + "원)- " + result.get(i) + "개");
        }
    }

    public static void printYield(double yield) {
        double result = Double.parseDouble(String.format("%.2f", yield));
        if (result < 1) {
            System.out.println("총 수익률은 " + result + "입니다. 기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (result >= 1) {
            System.out.println("총 수익률 1이상!!: 수익률은 " + result + " 입니다.");
        }
    }
}
