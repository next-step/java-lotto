package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Person;


public class ResultView {

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printMyLottos(Person person) {
        int purchasedLotto = person.getNumberOfLotto();
        System.out.printf("%d개를 구매했습니다.\n", purchasedLotto);
        for (Lotto lotto : person.getLottos()) {
            System.out.println(lotto.toString());
        }
        ResultView.println("");
    }

    public static void printResultStatistics(LottoStatistics statistics) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        for (int i = 0; i < 7; i++) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", i, statistics.winningAmount(i), statistics.matchedLottoNumberCount(i));
        }
    }
}
