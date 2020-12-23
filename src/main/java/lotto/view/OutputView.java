package lotto.view;

import lotto.domain.LottoStatistic;
import lotto.domain.Lottos;
import lotto.domain.Profit;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
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