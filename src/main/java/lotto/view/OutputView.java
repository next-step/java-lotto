package lotto.view;

import lotto.domain.LottoCount;
import lotto.domain.LottoStatistic;
import lotto.domain.Lottos;
import lotto.domain.Profit;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoCount(int manualCount, LottoCount automaticLottoCount) {
        System.out.println();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualCount, automaticLottoCount.getCount());
    }

    public void printLottos(Lottos lottos) {
        lottos.toStringLottos().forEach(System.out::println);
        System.out.println();
    }

    public void printStatistic(LottoStatistic statistic) {
        System.out.println();
        printMessage("당첨 통계");
        printMessage("---------");
        statistic.toFormattingStringList().forEach(System.out::println);
    }

    public void printProfit(Profit profit) {
        System.out.println(profit.toFormattingSting());
    }

}