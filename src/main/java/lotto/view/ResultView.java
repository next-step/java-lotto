package lotto.view;

import lotto.domain.LottoNumber;

public class ResultView {
    private static String COUNT_OF_LOTTO_QUESTION = "개를 구입했습니다.";

    public static void countOfLotto(int lottoCount) {
        System.out.println(lottoCount + COUNT_OF_LOTTO_QUESTION);
    }

    public static void printLottoNumber(LottoNumber lottoNumber) {
//        System.out.println(lottoNumber.value());
    }

    public static void printWinningStatistics(int[] matchesRecord) {

        System.out.println("당첨 통계");

        System.out.println("--------");

        System.out.println("3개 일치 (5000원)- " + Integer.toString(matchesRecord[0]) + "개");
        System.out.println("4개 일치 (50000원)- " + Integer.toString(matchesRecord[1]) + "개");
        System.out.println("5개 일치 (1500000원)- " + Integer.toString(matchesRecord[2]) + "개");
        System.out.println("6개 일치 (2000000000원)- " + Integer.toString(matchesRecord[3]) + "개");
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + Math.floor(profitRate * 100) / 100.0 + "입니다.");
    }
}
