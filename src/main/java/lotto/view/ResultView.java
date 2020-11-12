package lotto.view;

import lotto.asset.ResultViewConst;
import lotto.domain.Jackpot;
import lotto.domain.Lottos;
import lotto.domain.Result;

public class ResultView {
    private ResultView() {}

    private static void println(Object str) {
        System.out.println(str);
    }

    public static void printNumOfLottos(int numOfLottos) {
        println(numOfLottos + ResultViewConst.NUM_OF_LOTTOS_MSG);
    }

    public static void printLottos(Lottos lottos) {
        println(lottos);
    }

    public static void printResult(Result result, double rateOfReturn) {
        println(ResultViewConst.JACKPOT_STATISTICS_MSG);
        for (Jackpot jackpot : Jackpot.values()) {
            println(ResultViewConst.JACKPOT_MSG(jackpot, result.getNumOfCorrected(jackpot)));
        }
        println(ResultViewConst.RATE_OF_RETURN_MSG(rateOfReturn));
    }
}
