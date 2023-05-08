package lotto.view;

import lotto.domain.*;

import java.util.stream.Collectors;

public class ResultView {
    public static void showMyLottos(MyLottoGame myLottoGame) {
        for (int i = 0; i < myLottoGame.count(); i++) {
            printNumbers(myLottoGame.find(i).numbers());
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
        System.out.printf("3개 일치 (%d원) - %d개\n", Rank.FIFTH.getPrize(), result.countRank(Rank.FIFTH));
        System.out.printf("4개 일치 (%d원) - %d개\n", Rank.FOURTH.getPrize(), result.countRank(Rank.FOURTH));
        System.out.printf("5개 일치 (%d원) - %d개\n", Rank.THIRD.getPrize(), result.countRank(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치(%d원) - %d개\n", Rank.SECOND.getPrize(), result.countRank(Rank.SECOND));
        System.out.printf("6개 일치 (%d원) - %d개\n", Rank.FIRST.getPrize(), result.countRank(Rank.FIRST));
    }

    public static void showProfit(MyResult myResult) {
        System.out.printf("총 수익률은 %.2f입니다.", myResult.profit());
    }
}
