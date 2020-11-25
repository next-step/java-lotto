package lotto.view;

import lotto.model.Hit;
import lotto.model.lotto.LottoTicket;
import util.CommonUtils;

import java.util.List;
import java.util.Map;


public class ResultView {
    private final static String NUMBERS_DELIMITER = ", ";
    private final static String NUMBERS_FORMAT = "[ %s ]";
    private final static String BUY_MESSAGE = "수동으로 %d개, 자동으로 %d개를 구매했습니다.";
    private final static String RESULT_MESSAGE = "당첨 통계";
    private final static String RESULT_FORMAT = "%s- %d개";
    private final static String EARNING_RATE_FORMAT = "총 수익률은 %.2f입니다.";

    private final static String LINE_SEPARATOR = "---------";

    private ResultView(){}

    public static void printBuyMessage(int manualCount, int autoCount) {
        String buyMessage = String.format(BUY_MESSAGE, manualCount, autoCount);
        System.out.println(buyMessage);
    }

    public static void printLottoes(List<LottoTicket> lottos) {
        lottos.stream()
                .map(LottoTicket::getNumbers)
                .map(CommonUtils::sortedSetToArray)
                .map(ResultView::convertNumbersFormat)
                .forEach(System.out::println);
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

    private static String convertResultFormat(Map.Entry<Hit, Integer> e){
        return String.format(RESULT_FORMAT, e.getKey().toString(), e.getValue());
    }

    private static String convertNumbersFormat(String[] strings) {
        return String.format(NUMBERS_FORMAT, String.join(NUMBERS_DELIMITER, strings));
    }


}
