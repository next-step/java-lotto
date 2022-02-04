package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoCount(final int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.getLotto().toArray()));
        }
        System.out.println();
    }

    public static void printLottoResult(List<Integer> results, int money) {
        int total = 0;
        System.out.println("\n당첨 통계\n" + "---------");
        System.out.println("3개 일치 (5000원)-" + results.get(0) + "개");
        total += 5000 * results.get(0);
        System.out.println("4개 일치 (50000원)-" + results.get(1) + "개");
        total += 50000 * results.get(1);
        System.out.println("5개 일치 (1500000원)-" + results.get(2) + "개");
        total += 1500000 * results.get(2);
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)-" + results.get(3) + "개");
        total += 30000000 * results.get(3);
        System.out.println("6개 일치 (2000000000원)-" + results.get(4) + "개");
        total += 2000000000 * results.get(4);
        System.out.println("수익 > " + total);
        String profit = String.format("%.2f", (double) total / (double) money);
        System.out.println("총 수익률은 " + profit + "입니다.");
    }
}
