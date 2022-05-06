package view;

import domain.LottoRank;
import domain.LottoStatistics;
import domain.Lottos;

public class ResultView {
    public static void printHowLottoCount(int count, int buyManualLottoCount) {
        System.out.print("수동으로" + buyManualLottoCount + "개, ");
        System.out.println("자동으로" + count + "개를 구매했습니다.");
    }

    public static void printLottoList(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---------------");
        System.out.println("3개 일치 (5000원) - " + (int) lottoStatistics.calculateNumbersCount(LottoRank.THREE_NUMBERS) + "개");
        System.out.println("4개 일치 (50000원) - " + (int) lottoStatistics.calculateNumbersCount(LottoRank.FOUR_NUMBERS) + "개");
        System.out.println("5개 일치 (1500000원) - " + (int) lottoStatistics.calculateNumbersCount(LottoRank.FIVE_NUMBERS) + "개");
        System.out.println("5개 일치, 보너스 번호 일치(30000000원) - "
                + (int) lottoStatistics.calculateNumbersCount(LottoRank.FIVE_NUMBERS_AND_BONUS) + "개");
        System.out.println("6개 일치 (2000000000원) - " + (int) lottoStatistics.calculateNumbersCount(LottoRank.SIX_NUMBERS) + "개");
        System.out.print("총 수익률은 " + lottoStatistics.statistics() + "입니다.");
    }

}
