package lotto.view;

import lotto.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

public class ResultView {
    private static final String BUYING_COUNT_MESSAGE = "%d 개를 구매했습니다.";
    private static final String MATCHING_COUNT_MESSAGE = "%d개 일치 (%d원)-%d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f입니다 (%s)";
    private static final String PROFIT_RESULT_MESSAGE = "기준이 1이기 때문에 결과적으로 이익이라는 의미임";
    private static final String NOT_PROFIT_RESULT_MESSAGE = "기준이 1이기 때문에 결과적으로 손해라는 의미임";

    private ResultView() {
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottosValues = lottos.getValues();
        System.out.println(format(BUYING_COUNT_MESSAGE, lottosValues.size()));
        for (Lotto lotto : lottosValues) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(WinningResult result, ProfitStatistics statistics) {
        System.out.println(Stream.of(WinningType.values())
               .filter(type -> !type.equals(WinningType.NOTHING))
               .sorted(Collections.reverseOrder())
               .map(type -> format(MATCHING_COUNT_MESSAGE,
                       type.getMatchCount(), type.getPrize().longValue(), result.count(type)))
               .collect(Collectors.joining(System.lineSeparator())));

        double profitRate = statistics.calculateProfitRate();
        System.out.println(format(PROFIT_RATE_MESSAGE,
                profitRate, profitRate < 1? NOT_PROFIT_RESULT_MESSAGE : PROFIT_RESULT_MESSAGE));
    }
}
