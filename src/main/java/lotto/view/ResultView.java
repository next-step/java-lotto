package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.view.printable.StatisticsPrintable;

public class ResultView {
    private ResultView() {}

    private static void println(Object str) {
        System.out.println(str);
    }

    public static void printNumOfLottos(int numOfLottos) {
        println(numOfLottos + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        println(lottos);
    }

    public static void printStatistics(Result result, Money purchaseMoney) {
        new StatisticsPrintable(result, purchaseMoney).print();
    }
}
