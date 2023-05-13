package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void showMyLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printNumbers(lotto.numbers());
        }
        System.out.println();
    }

    public static void showLottoCount(MyPurchase myPurchase) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d장 구매했습니다.\n", myPurchase.manualCount(), myPurchase.autoCount());
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
        System.out.printf("%d개 일치 (%d원) - %d개\n", Rank.FIFTH.getMatchCount(), Rank.FIFTH.getPrize(), result.countRank(Rank.FIFTH));
        System.out.printf("%d개 일치 (%d원) - %d개\n", Rank.FOURTH.getMatchCount(), Rank.FOURTH.getPrize(), result.countRank(Rank.FOURTH));
        System.out.printf("%d개 일치 (%d원) - %d개\n", Rank.THIRD.getMatchCount(), Rank.THIRD.getPrize(), result.countRank(Rank.THIRD));
        System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개\n", Rank.SECOND.getMatchCount(), Rank.SECOND.getPrize(), result.countRank(Rank.SECOND));
        System.out.printf("%d개 일치 (%d원) - %d개\n", Rank.FIRST.getMatchCount(), Rank.FIRST.getPrize(), result.countRank(Rank.FIRST));
        System.out.printf("총 수익률은 %.2f입니다.", result.profit());
    }
}
