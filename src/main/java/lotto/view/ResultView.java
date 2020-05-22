package lotto.view;

import lotto.domain.dto.LottoTicketDto;
import lotto.domain.prize.LottoPrizeResult;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private final static String TICKET_PURCHASE_CONFIRM_MESSAGE = "%d개를 구입했습니다.";
    private final static String RESULT = "\n당첨 통계\n--------";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%% 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String PRIZE_RESULT_INFO_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String NEW_LINE = "\n";

    public static void printPurchaseInfo(final List<LottoTicketDto> tickets) {
        printPurchasedTicketCount(tickets.size());
        printTickets(tickets);
    }

    private static void printPurchasedTicketCount(final int count) {
        System.out.println(String.format(TICKET_PURCHASE_CONFIRM_MESSAGE, count));
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RESULT).append(NEW_LINE);

        result.getMatchedPrizes()
                .keySet()
                .forEach(prize ->
                        stringBuilder.append(
                                String.format(PRIZE_RESULT_INFO_FORMAT,
                                        prize.getMatchedNumbersCount(),
                                        prize.getPrizeMoney(),
                                        result.getMatchedTicketCount(prize)))
                        .append(NEW_LINE)
                );
        System.out.println(stringBuilder);
    }

    private static void printProfitRate(final float profitRate) {
        System.out.println(String.format(PROFIT_RATE_FORMAT, profitRate));
    }
}
