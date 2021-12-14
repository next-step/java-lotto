package lottery.view;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryResult;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTickets;
import lottery.domain.MatchedCountAndPrizePair;

public class ResultView {

    private static final String MESSAGE_FORMAT_PURCHASE_CONFIRM = "%d개를 구매했습니다.%s";
    private static final String MESSAGE_FORMAT_LOTTERY_NUMBERS = "[%d, %d, %d, %d, %d, %d]\n";
    private static final String MESSAGE_STATISTICS = "당첨 통계";
    private static final String LINE_SEPARATOR = "---------";
    private static final String MESSAGE_FORMAT_MATCHED_LOTTERIES = "%d개 일치 (%d원)- %d개 %s";
    private static final String MESSAGE_FORMAT_OVERALL = "총 수익률은 %.2f 입니다.";

    public static void showPurchaseInfo(final LotteryTickets lotteryTickets) {
        final int numberOfTickets = lotteryTickets.tickets().size();

        System.out.printf(MESSAGE_FORMAT_PURCHASE_CONFIRM, numberOfTickets,
            System.lineSeparator());

        for (final LotteryTicket ticket : lotteryTickets.tickets()) {
            System.out.printf(MESSAGE_FORMAT_LOTTERY_NUMBERS, ticket.getNumbers().stream().map(LotteryNumber::value).toArray());
        }

        System.out.println();
    }

    public static void showResult(final LotteryResult lotteryResult) {

        System.out.println(MESSAGE_STATISTICS);
        System.out.println(LINE_SEPARATOR);

        for (MatchedCountAndPrizePair matchedCountAndPrizePairs : LotteryResult.MATCHED_COUNT_AND_PRIZE_PAIRS) {
            final int matchedCount = matchedCountAndPrizePairs.matchedCount();
            final long prize = matchedCountAndPrizePairs.prize();

            System.out.printf(MESSAGE_FORMAT_MATCHED_LOTTERIES,
                matchedCount,
                prize,
                lotteryResult.winningLotteryCount(matchedCount),
                System.lineSeparator());
        }

        System.out.printf(MESSAGE_FORMAT_OVERALL, lotteryResult.earningRatio());
    }
}
