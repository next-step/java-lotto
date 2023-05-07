package lotto.view;

import lotto.domain.*;

import java.util.stream.Collectors;

public class ResultView {
    public static void showMyLottos(MyLottos myLottos) {
        for (int i = 0; i < myLottos.count(); i++) {
            printNumbers(myLottos.find(i).numbers());
        }
        System.out.println();
    }

    public static void showLottoCount(MyPurchase myPurchase) {
        System.out.println(myPurchase.count() + "개를 구매했습니다.");
    }

    private static void printNumbers(Numbers numbers) {
        System.out.println(numbers.getValues().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"))
        );
    }

    public static void showWinLotto(WinLotto winLotto) {
        System.out.print("지난 주 당첨 번호 : ");
        printNumbers(winLotto.numbers());
        System.out.println("보너스 번호 : [" + winLotto.bonusNumber() + "]\n");
    }

    public static void showLottoResult(MyResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (%d원) - %d개\n", LottoRule.RANK_FOURTH_PRIZE, result.rankFourthCount());
        System.out.printf("4개 일치 (%d원) - %d개\n", LottoRule.RANK_THIRD_PRIZE, result.rankThirdCount());
        System.out.printf("5개 일치 (%d원) - %d개\n", LottoRule.RANK_SECOND_PRIZE, result.rankSecondCount());
        System.out.printf("6개 일치 (%d원) - %d개\n", LottoRule.RANK_FIRST_PRIZE, result.rankFirstCount());
    }

    public static void showProfit(double profit) {
        System.out.printf("총 수익률은 %.2f입니다.", profit);
    }
}
