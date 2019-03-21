package view;

import domain.PrizeMoney;
import util.Calculator;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int THOUSAND_UNiTS = 1000;

    public static int purchaseLottoCount(int money) {
        int lottoCount = money / THOUSAND_UNiTS;
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public static void printLotto(List<Integer> lotto) {
        System.out.println(lotto.toString());
    }

    public static void statisticsWinner(Map<Integer, Integer> produceResults) {
        System.out.println("당첨 통계\n------");
        System.out.println("3개 일치 (" + PrizeMoney.THREE.getPrice() + "원)-" + Calculator.nullToZero(produceResults.get(3)) + "개");
        System.out.println("4개 일치 (" + PrizeMoney.FOUR.getPrice() + "원)-" + Calculator.nullToZero(produceResults.get(4)) + "개");
        System.out.println("5개 일치 (" + PrizeMoney.FIVE.getPrice() + "원)-" + Calculator.nullToZero(produceResults.get(5)) + "개");
        System.out.println("6개 일치 (" + PrizeMoney.SIX.getPrice() + "원)-" + Calculator.nullToZero(produceResults.get(6)) + "개");
    }

    public static void printYield(double yield) {
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}
