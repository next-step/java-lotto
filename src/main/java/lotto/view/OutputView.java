package lotto.view;

import lotto.domain.LottoStatistic;
import lotto.domain.Lottos;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public void printLottos(Lottos lottos) {
        lottos.print();
        System.out.println();
    }

    public void printStatistic(LottoStatistic statistic) {
        System.out.println();
        printMessage("당첨 통계");
        printMessage("---------");
        statistic.print();
    }

}
