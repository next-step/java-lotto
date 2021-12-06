package lottery.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.util.Pair;
import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTickets;
import lottery.dto.LotteryResultDto;
import lottery.dto.LotteryTicketResultDto;

public class ResultView {

    private static final List<Pair<Integer, Long>> MATCHED_COUNT_AND_PRIZE_PAIRS = Arrays.asList(
        new Pair<>(3, 5000L),
        new Pair<>(4, 50000L),
        new Pair<>(5, 1500000L),
        new Pair<>(6, 2000000000L));

    private static final String MESSAGE_FORMAT_PURCHASE_CONFIRM = "%d개를 구매했습니다.%s";
    private static final String MESSAGE_FORMAT_LOTTERY_NUMBERS = "[%d, %d, %d, %d, %d, %d]\n";
    private static final String MESSAGE_STATISTICS = "당첨 통계";
    private static final String LINE_SEPARATOR = "---------";
    private static final String MESSAGE_FORMAT_MATCHED_LOTTERIES = "%d개 일치 (%d원)- %d개 %s";
    private static final String MESSAGE_FORMAT_OVERALL = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void showPurchaseInfo(final LotteryTickets lotteryTickets) {
        final int numberOfTickets = lotteryTickets.getTickets().size();

        System.out.printf(MESSAGE_FORMAT_PURCHASE_CONFIRM, numberOfTickets,
            System.lineSeparator());

        for (final LotteryTicket ticket : lotteryTickets.getTickets()) {
            System.out.printf(MESSAGE_FORMAT_LOTTERY_NUMBERS, ticket.getNumbers().stream().map(LotteryNumber::value).toArray());
        }

        System.out.println();
    }

    public static void showResult(final LotteryResultDto result) {
        final Map<Integer, Long> groupByResult = result.getLotteryTicketResults()
            .stream()
            .filter(LotteryTicketResultDto::won)
            .collect(Collectors.groupingBy(LotteryTicketResultDto::getNumberOfMatchedLotteryNumbers, Collectors.counting()));

        System.out.println(MESSAGE_STATISTICS);
        System.out.println(LINE_SEPARATOR);

        long sumOfPrize = 0;
        for (Pair<Integer, Long> matchedCountAndPrizePairs : MATCHED_COUNT_AND_PRIZE_PAIRS) {
            final int matchedCount = matchedCountAndPrizePairs.getKey();
            final long prize = matchedCountAndPrizePairs.getValue();
            long numberOfMatchedTickets = 0;
            if (groupByResult.containsKey(matchedCount)) {
                numberOfMatchedTickets = groupByResult.get(matchedCount);
            }

            System.out.printf(MESSAGE_FORMAT_MATCHED_LOTTERIES,
                matchedCount,
                prize,
                numberOfMatchedTickets,
                System.lineSeparator());

            sumOfPrize += prize * numberOfMatchedTickets;
        }

        System.out.printf(MESSAGE_FORMAT_OVERALL, sumOfPrize / (result.getLotteryCount() * 1000f));
    }
}
