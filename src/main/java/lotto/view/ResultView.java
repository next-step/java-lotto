package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Person;


public class ResultView {

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printMyLottos(Person person) {
        int purchasedLotto = person.numberOfLotto();
        System.out.printf("%d개를 구매했습니다.\n", purchasedLotto);
        for (Lotto lotto : person.lottos()) {
            System.out.println(lotto.toString());
        }
        ResultView.println("");
    }

    public static void printResultStatistics(LottoStatistics statistics) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        for (int i = 0; i < 7; i++) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", i, statistics.winningAmount(i), statistics.numberOfWinningLotto(i));
        }
    }

    public static void printProfitRate(LottoStatistics statistics) {
        double profitRate = statistics.profitRate();
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
        if (profitRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
