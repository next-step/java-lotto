package step3;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultView {
    public static void countLottoResult(int countLotto) {
        System.out.println(countLotto + "개를 구매했습니다.");
    }

    public static void goPrint(Set<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            printPurchasedLottos(Lotto.valueOf(purchasedLotto));
        }
        System.out.println();
    }

    private static void printPurchasedLottos(List<Integer> purchasedLotto) {
        System.out.println(purchasedLotto);
    }

    public static void printAboutRank(Map<Integer, Integer> summaryResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int key : summaryResult.keySet()) {
            System.out.println(goPrint(summaryResult, key));
        }
    }

    private static String goPrint(Map<Integer, Integer> summaryResult, int key) {
        if (LottoGenerator.BONUS_WINNING_VALID_NUMBER == key) {
            return hasBonusCheck(summaryResult, key);
        }
        return key + "개 일치 (" + Prize.matchOfCount(key, false).getWinningMoney() + "원)- " + summaryResult.get(key) + "개";
    }

    private static String hasBonusCheck(Map<Integer, Integer> summaryResult, int key) {
        return key + "개 일치 (" + Prize.matchOfCount(key, false).getWinningMoney() + "원)- " + (summaryResult.get(key) - LottoLottery.bonusWinningCount) + "개\n" +
                +key + "개 일치, 보너스 볼 일치 (" + Prize.matchOfCount(key, true).getWinningMoney() + "원)- " + LottoLottery.bonusWinningCount + "개";
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
