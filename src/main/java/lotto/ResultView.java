package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String STATISTICS_MESSAGE = "\n당첨통계\n"
            + "---------";
    public static final String MATCHED_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    public static final String RETURN_ON_INVESTMENT_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";

    public static final String NEW_LINE = "\n";

    private ResultView() {

    }

    public static void printLottoPurchased(List<Lotto> lottoList) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, lottoList.size());
        String lottoListMessage = lottoList.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(NEW_LINE));
        System.out.println(lottoListMessage);
        System.out.println();
    }

    public static void printWinningStatistics(WinningStatistics statistics) {
        System.out.println(STATISTICS_MESSAGE);
        String matchedResultMessage = Arrays.stream(WinningType.values())
                .map(type -> String.format(
                        MATCHED_RESULT_MESSAGE,
                        type.matchNumberCount(),
                        type.winnings(),
                        statistics.winningLogs()
                                .getOrDefault(type, 0)))
                .collect(Collectors.joining());
        System.out.print(matchedResultMessage);
        System.out.println(String.format(RETURN_ON_INVESTMENT_MESSAGE, statistics.returnOnInvestment()));
    }
}
