package lotto.view;

import lotto.model.Hit;

import java.util.Map;


public class ResultView {
    private final static String RESULT_MESSAGE = "당첨 통계";
    private final static String RESULT_FORMAT = "%s- %d개";
    private final static String EARNING_RATE_FORMAT = "총 수익률은 %.2f입니다.";

    private final static String LINE_SEPARATOR = "---------";

    private ResultView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printResult(Map<Hit, Integer> result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(LINE_SEPARATOR);
        result.entrySet().stream()
                .map(ResultView::convertResultFormat)
                .forEach(System.out::println);
    }

    public static void printEarningRate(double earningRate) {
        System.out.println(String.format(EARNING_RATE_FORMAT, earningRate));
    }

    private static String convertResultFormat(Map.Entry<Hit, Integer> e) {
        return String.format(RESULT_FORMAT, e.getKey(), e.getValue());
    }
}
