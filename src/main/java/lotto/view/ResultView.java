package lotto.view;

import lotto.model.Hit;
import util.CommonUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultView {
    private final static String NUMBERS_DELIMITER = ", ";
    private final static String NUMBERS_FORMAT = "[ %s ]";
    private final static String BUY_MESSAGE = "개를 구매했습니다.";
    private final static String RESULT_MESSAGE = "당첨 통계";
    private final static String RESULT_FORMAT = "%s- %d개";
    private final static String EARNING_RATE_FORMAT = "총 수익률은 %.2f입니다.";

    private final static String LINE_SEPARATOR = "---------";

    public void printBuyMessage(int count) {
        System.out.println(count + BUY_MESSAGE);
    }

    public void printLottoes(List<Set<Integer>> lottos) {
        lottos.stream()
                .map(CommonUtils::setToArray)
                .map(this::convertNumbersFormat)
                .forEach(System.out::println);
    }

    public void printResult(Map<Hit, Integer> result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(LINE_SEPARATOR);
        result.entrySet().stream()
                .map(e -> String.format(RESULT_FORMAT, e.getKey().toString(), e.getValue()))
                .forEach(System.out::println);
    }

    public void printEarningRate(double earningRate) {
        System.out.println(String.format(EARNING_RATE_FORMAT, earningRate));
    }

    private String convertNumbersFormat(String[] strings) {
        return String.format(NUMBERS_FORMAT, String.join(NUMBERS_DELIMITER, strings));
    }


}
