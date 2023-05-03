package lotto.view;

import lotto.domain.*;

public class ResultView {
    public static void showMyLottos(MyLottos myLottos) {
        for (int i = 0; i < myLottos.count(); i++) {
            printNumber(myLottos.find(i).numbers());
        }
        System.out.println();
    }

    private static void printNumber(Numbers numbers) {
        System.out.print("["+numbers.find(0));
        for (int i = 1; i < numbers.count(); i++) {
            System.out.print(", "+numbers.find(i));
        }
        System.out.println("]");
    }

    public static void showWinLotto(Numbers numbers) {
        System.out.print("지난 주 당첨 번호 : ");
        printNumber(numbers);
        System.out.println();
    }

    public static void showLottoResult(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (%d원) - %d개\n", LottoRule.RANK_FOURTH_PRIZE, result.rankFourthCount());
        System.out.printf("4개 일치 (%d원) - %d개\n", LottoRule.RANK_THIRD_PRIZE, result.rankThirdCount());
        System.out.printf("5개 일치 (%d원) - %d개\n", LottoRule.RANK_SECOND_PRIZE, result.rankSecondCount());
        System.out.printf("6개 일치 (%d원) - %d개\n", LottoRule.RANK_FIRST_PRIZE, result.rankFirstCount());
    }

    public static void showProfit(double profit) {
        System.out.printf("총 수익률은 %.2f입니다.",profit);
    }
}
