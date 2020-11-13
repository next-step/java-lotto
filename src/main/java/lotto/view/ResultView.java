package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;

public class ResultView {
    private ResultView() {}

    private static void println(Object str) {
        System.out.println(str);
    }

    public static void printNumOfLottos(int numOfLottos) {
        println(
                ResultMessage.getNumOfLottosMsg(numOfLottos)
        );
    }

    public static void printLottos(Lottos lottos) {
        println(lottos);
    }

    public static void printStatistics(Result result, Money purchaseMoney) {
        println(
                ResultMessage.getJackpotStatistics(result, purchaseMoney)
        );
    }
}
