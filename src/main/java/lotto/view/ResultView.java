package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Result;

import java.util.List;

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

    public static void printLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto + "\n");
        }
        println(sb);
    }

    public static void printStatistics(Result result, Money purchaseMoney) {
        println(
                ResultMessage.getJackpotStatistics(result, purchaseMoney)
        );
    }
}
