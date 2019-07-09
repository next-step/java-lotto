package step2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ResultView {
    public void countLottoResult(int countLotto) {
        System.out.println(countLotto + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(Set<ArrayList<Integer>> purchasedLottos) {
        for (ArrayList<Integer> purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto);
        }
        printWinningStatistics();
    }

    private void printWinningStatistics() {
        System.out.println();
    }

    public void printFinalResult(Map<Integer, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + LottoLottery.FOURTH + "원)- " + result.get(3) + "개");
        System.out.println("4개 일치 (" + LottoLottery.THIRD + "원)- " + result.get(4) + "개");
        System.out.println("5개 일치 (" + LottoLottery.SECOND + "원)- " + result.get(5) + "개");
        System.out.println("6개 일치 (" + LottoLottery.FIRST + "원)- " + result.get(6) + "개");
    }

    public void printYield(double yield) {
        double result = yield * 100;
        if (result < 1) {
            System.out.println("총 수익률은 " + result + "입니다. 기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (result >= 1) {
            System.out.printf("총 수익률 1이상!! : 수익률 ");
            System.out.format("%.2f%n" , result);
        }
    }
}
