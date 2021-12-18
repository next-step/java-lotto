package lottery.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lottery.domain.LotteryNumber;
import lottery.domain.LotteryResult;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTickets;
import lottery.domain.Rank;

public class ResultView {

    private static final String MESSAGE_FORMAT_PURCHASE_CONFIRM = "%d개를 구매했습니다.%s";
    private static final String MESSAGE_FORMAT_LOTTERY_NUMBERS = "[%d, %d, %d, %d, %d, %d]\n";
    private static final String MESSAGE_STATISTICS = "당첨 통계";
    private static final String LINE_SEPARATOR = "---------";
    private static final String MESSAGE_FORMAT_MATCHED_LOTTERIES = "%d개 일치%s (%d원)- %d개 %s";
    private static final String MESSAGE_SECOND_RANK_LOTTERY_ADDITIONAL_INFO = ", 보너스 불 일치";
    private static final String MESSAGE_FORMAT_OVERALL = "총 수익률은 %.2f 입니다.";

    public static void showPurchaseInfo(final LotteryTickets lotteryTickets) {
        final int numberOfTickets = lotteryTickets.tickets().size();

        System.out.printf(MESSAGE_FORMAT_PURCHASE_CONFIRM, numberOfTickets,
            System.lineSeparator());

        for (final LotteryTicket ticket : lotteryTickets.tickets()) {
            String lotteryString = ticket.getNumbers()
                .stream()
                .map(LotteryNumber::value)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lotteryString);
        }

        System.out.println();
    }

    public static void showResult(final LotteryResult lotteryResult) {
        System.out.println(MESSAGE_STATISTICS);
        System.out.println(LINE_SEPARATOR);

        final List<Rank> ranks = Arrays.stream(Rank.values())
            .filter(rank -> rank != Rank.MISS)
            .collect(Collectors.toList());

        Collections.reverse(ranks);

        for (Rank rank : ranks) {
            final int matchedCount = rank.getCountOfMatch();
            final long prize = rank.getWinningMoney();

            System.out.printf(MESSAGE_FORMAT_MATCHED_LOTTERIES,
                matchedCount,
                getAdditionalInfoMessage(rank),
                prize,
                lotteryResult.winningLotteryCount(rank),
                System.lineSeparator());
        }

        System.out.printf(MESSAGE_FORMAT_OVERALL, lotteryResult.getEarningRatio());
    }

    private static String getAdditionalInfoMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return MESSAGE_SECOND_RANK_LOTTERY_ADDITIONAL_INFO;
        }

        return "";
    }
}
