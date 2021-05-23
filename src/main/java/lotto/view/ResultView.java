package lotto.view;

import lotto.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

public class ResultView {
    private static final String BUYING_COUNT_MESSAGE = "수동으로 %d장 자동으로 %d개를 구매했습니다.";
    private static final String MATCHING_STATISTICS_MESSAGE = "당첨통계";
    private static final String LINE_DELIMITER = "---------";
    private static final String MATCHING_COUNT_MESSAGE = "%d개 일치 (%d원)-%d개";
    private static final String MATCHING_COUNT_MESSAGE_FOR_SECOND = "%d개 일치, 보너스 볼 일치 (%d원)-%d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f입니다 (%s)";
    private static final String PROFIT_RESULT_MESSAGE = "기준이 1이기 때문에 결과적으로 이익이라는 의미임";
    private static final String NOT_PROFIT_RESULT_MESSAGE = "기준이 1이기 때문에 결과적으로 손해라는 의미임";

    private ResultView() {
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottosValues = lottos.getValues();
        System.out.println(format(BUYING_COUNT_MESSAGE, lottos.getManuals().size(), lottos.getAutos().size()));
        for (Lotto lotto : lottosValues) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(WinningResults results, ProfitStatistics statistics) {
        System.out.print(System.lineSeparator());
        System.out.println(MATCHING_STATISTICS_MESSAGE);
        System.out.println(LINE_DELIMITER);
        System.out.println(Stream.of(WinningType.values())
                .filter(type -> !type.equals(WinningType.NOTHING))
                .sorted(Collections.reverseOrder())
                .map(type -> format(
                        type.equals(WinningType.SECOND) ? MATCHING_COUNT_MESSAGE_FOR_SECOND : MATCHING_COUNT_MESSAGE,
                        type.getMatchCount(), type.getPrize().longValue(), results.count(type)))
                .collect(Collectors.joining(System.lineSeparator())));

        double profitRate = statistics.calculateProfitRate();
        System.out.println(format(PROFIT_RATE_MESSAGE,
                profitRate, profitRate < 1 ? NOT_PROFIT_RESULT_MESSAGE : PROFIT_RESULT_MESSAGE));
    }
}
