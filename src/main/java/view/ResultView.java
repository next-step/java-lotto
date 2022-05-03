package view;

import domain.LottoStatistics;
import domain.Lottos;

public class ResultView {
    public static void printHowLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoList(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---------------");
        System.out.println("3개 일치 (5000원) - " + (int) lottoStatistics.calculateNumbersCount(5000) + "개");
        System.out.println("4개 일치 (50000원) - " + (int) lottoStatistics.calculateNumbersCount(50000) + "개");
        System.out.println("5개 일치 (1500000원) - " + (int) lottoStatistics.calculateNumbersCount(1500000) + "개");
        System.out.println("5개 일치, 보너스 번호 일치(30000000원) - "
                + (int) lottoStatistics.calculateNumbersCount(30000000) + "개");
        System.out.println("6개 일치 (2000000000원) - " + (int) lottoStatistics.calculateNumbersCount(2000000000) + "개");
        System.out.print("총 수익률은 " + lottoStatistics.statistics() + "입니다.");
    }

}
