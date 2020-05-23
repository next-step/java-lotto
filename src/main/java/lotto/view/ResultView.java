package lotto.view;

import lotto.domain.dto.LottoTicketDto;
import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.prize.Prize;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private final static String TICKET_PURCHASE_CONFIRM_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private final static String RESULT = "\n당첨 통계\n--------";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%% 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String PRIZE_RESULT_INFO_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String SECOND_PRIZE_RESULT_INFO_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";

    public static void printPurchaseInfo(final int manualTicketsCount, final List<LottoTicketDto> tickets) {
        printPurchasedTicketCount(manualTicketsCount, tickets.size());
        printTickets(tickets);
    }

    private static void printPurchasedTicketCount(final int manualTicketsCount, final int allTicketsCount) {
        System.out.println();
        System.out.println(String.format(TICKET_PURCHASE_CONFIRM_MESSAGE,
                manualTicketsCount,
                allTicketsCount - manualTicketsCount));
    }

    private static void printTickets(final List<LottoTicketDto> tickets) {
        tickets.stream()
                .map(LottoTicketDto::getNumbers)
                .map(List::toArray)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    public static void printResult(LottoPrizeResult result) {
        printStatisticsResult(result);
        printProfitRate(result.calculateProfitRate());
    }

    private static void printStatisticsResult(final LottoPrizeResult result) {
        System.out.println(RESULT);

        result.getMatchedPrizes()
                .keySet()
                .forEach(prize -> printPrizeResult(result, prize));
    }

    private static void printPrizeResult(final LottoPrizeResult result, final Prize prize) {
        String format = PRIZE_RESULT_INFO_FORMAT;
        if (Prize.SECOND.equals(prize)) {
            format = SECOND_PRIZE_RESULT_INFO_FORMAT;
        }

        System.out.println(String.format(format,
                prize.getMatchedNumbersCount(),
                prize.getPrizeMoney(),
                result.getMatchedTicketCount(prize)));
    }

    private static void printProfitRate(final float profitRate) {
        System.out.println(String.format(PROFIT_RATE_FORMAT, profitRate));
    }
}
