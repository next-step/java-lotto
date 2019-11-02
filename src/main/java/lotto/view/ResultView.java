package lotto.view;

import lotto.domain.IssuedLottos;
import lotto.domain.Lotto;

public class ResultView {

    public static void printTotalLottoCount(final int totalCount) {
        System.out.println(totalCount + "개를 구매했습니다.");
    }

    public static void printIssuedLottos(final IssuedLottos issuedLottos) {
        for (Lotto issuedLotto : issuedLottos.findAllIssuedLottos()) {
            System.out.println(issuedLotto.findNumbers());
        }
    }

    public static void printWinStatus(final int threeWinCount, final int fourWinCount, final int fiveWinCount, final int sixWinCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printThreeWinCount(threeWinCount);
        printFourWinCount(fourWinCount);
        printFiveWinCount(fiveWinCount);
        printSixWinCount(sixWinCount);
    }

    private static void printThreeWinCount(final int threeWinCount) {
        System.out.println("3개 일치 (5000원) - " + threeWinCount);
    }

    private static void printFourWinCount(final int fourWinCount) {
        System.out.println("4개 일치 (50000원) - " + fourWinCount);
    }

    private static void printFiveWinCount(final int fiveWinCount) {
        System.out.println("5개 일치 (1500000원) - " + fiveWinCount);
    }

    private static void printSixWinCount(final int sixWinCount) {
        System.out.println("6개 일치 (2000000000원) - " + sixWinCount);
    }

    public static void printResult(final double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.(기준이 1이기 때문에 결과적으로 " + (rate >= 1 ? "이득" : "손해") + "라는 의미임)");
    }
}
