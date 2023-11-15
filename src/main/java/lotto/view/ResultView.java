package lotto.view;

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

        public static void printStatistics(int[] statistics) {
            System.out.println("당첨 통계");
            System.out.println("---------");
            System.out.println("3개 일치 (5000원) - " + statistics[0] + "개");
            System.out.println("4개 일치 (50000원) - " + statistics[1] + "개");
            System.out.println("5개 일치 (1500000원) - " + statistics[2] + "개");
            System.out.println("5개 일치, 보너스 볼 일치 (30000000원) - " + statistics[3] + "개");
            System.out.println("6개 일치 (2000000000원) - " + statistics[4] + "개");
            System.out.println("총 수익률은 " + String.format("%.2f", calculateYield(statistics)) + "%입니다.");
        }


}
