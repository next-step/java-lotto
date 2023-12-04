package lotto.view;

import lotto.domain.Rank;
import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printPurchaseCount(int input) {
        System.out.println(input + "개를 구매했습니다.");
    }

    public static void printPurchasedLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningStatistics() {
        System.out.println("당첨 통계\n---------");
    }

    public static void printWinningResult(Rank rank, int count) {
        if (rank.getPrize() == 0) {
            return;
        }
        if (rank == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", rank.getCount(), rank.getPrize(), count);
            return;
        }
        System.out.printf("%d개 일치 (%d원) - %d개\n", rank.getCount(), rank.getPrize(), count);
    }

    public static void printProfitPercentage(double percentage) {
        System.out.printf("총 수익률은 %.2f입니다.", percentage);
    }
}
