package lotto.view;

import static lotto.RewardPrice.*;
import static lotto.RoRCalculator.calculateYield;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(String lottos) {
        System.out.println(lottos);
    }

    public static void printStatistics(int[] statistics, int lottoCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(MATCH_3.getCount() + "개 일치 (" + MATCH_3.getPrice() + "원) - " + statistics[0] + "개");
        System.out.println(MATCH_4.getCount() + "개 일치 (" + MATCH_4.getPrice() + "원) - " + statistics[1] + "개");
        System.out.println(MATCH_5.getCount() + "개 일치 (" + MATCH_5.getPrice() + "원) - " + statistics[2] + "개");
        System.out.println(MATCH_6.getCount() + "개 일치 (" + MATCH_6.getPrice() + "원) - " + statistics[3] + "개");
        System.out.println("총 수익률은 " + String.format("%.2f", calculateYield(statistics, lottoCount)) + "%입니다.");
    }


}
