/*
 * UI 출력을 담당하는 클래스
 * */
package lotto.ui;

import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.stream.IntStream;

import static lotto.domain.WinningLotto.MINIMUM_MATCH;

public class ResultView {

    public static final String RESULT_MESSAGE = "당첨 통계";
    public static final String RESULT_MESSAGE_LINE = "---------";
    public static final String YIELD_MESSAGE_BEFORE = "총 수익률은 ";
    public static final String YIELD_MESSAGE_AFTER = " 입니다.";
    public static final String YIELD_DECIMAL_PLACE = "%.2f";
    public static final String YIELD_MESSAGE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String YIELD_MESSAGE_PROFIT = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    public static final int YIELD_BOUND = 1;

    public static final String DELIMITER = ", ";
    public static final String DELIMITER_ARRAY = "], ";
    public static final String REPLACE = "]\n";

    public static void printLottos(Lottos lottos) {
        String lottosStr = lottos.toString().replace(DELIMITER_ARRAY, REPLACE);
        System.out.println(lottosStr.substring(1, lottosStr.length() - 1));
    }

    public static void printResult(WinningLotto winning, int buyNum) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(RESULT_MESSAGE_LINE);
        System.out.println(changeResultStr(winning.toString()));
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


    public static String changeResultStr(String str) {
        StringBuilder sb = new StringBuilder();
        str = str.substring(1, str.length() - 1);
        int[] result = Arrays.stream(str.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();

        IntStream.range(0, result.length)
                .filter(i -> i >= MINIMUM_MATCH)
                .forEach(i -> {
                    sb.append(i + "개 일치 (" + Price.winningPrice(i) + "원) - " + result[i] + "개");
                    sb.append((System.getProperty("line.separator")));
                });
        return sb.toString();
    }


}
