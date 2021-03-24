/*
 * UI 출력을 담당하는 클래스
 * */
package lotto.ui;

import lotto.domain.Lottos;
import lotto.domain.Winning;

public class ResultView {

    public static final String RESULT_MESSAGE = "당첨 통계";
    public static final String RESULT_MESSAGE_LINE = "---------";
    public static final String YIELD_MESSAGE_BEFORE = "총 수익률은 ";
    public static final String YIELD_MESSAGE_AFTER =  " 입니다.";
    public static final String YIELD_DECIMAL_PLACE = "%.2f";
    public static final String YIELD_MESSAGE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String YIELD_MESSAGE_PROFIT = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    public static final int YIELD_BOUND = 1;

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printResult(Winning winning, int buyNum) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(RESULT_MESSAGE_LINE);
        System.out.println(winning.toString());
        printYield(winning.yield(buyNum));
    }

    public static void printYield(double yield) {
        System.out.print(YIELD_MESSAGE_BEFORE + String.format(YIELD_DECIMAL_PLACE, yield) + YIELD_MESSAGE_AFTER);
        if (yield <= YIELD_BOUND) {
            System.out.print(YIELD_MESSAGE_LOSS);
            return;
        }
        System.out.print(YIELD_MESSAGE_PROFIT);
    }
}
