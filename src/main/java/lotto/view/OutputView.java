package lotto.view;

import lotto.domain.*;

import java.math.BigDecimal;
import java.util.*;

public class OutputView {

    private static final String PURCHASED_LOTTO_TICKET_MESSAGE = "자동으로 %d장, 수동으로 %d장 로또 티켓을 구매했습니다.";
    private static final String GOOD_RATE_RESULT = "(기준이 1이기 때문에 결과적으로 이득라는 의미임)";
    private static final String BAD_RATE_RESULT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int AVERAGE_RATE_VALUE = 1;
    private static final String WINNING_STATISTICS_MESSAGE = "[당첨 통계]";
    private static final String TOTAL_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f 입니다.";
    private static final String DRAW_LOTTO_RESULT_MESSAGE = "(%d 원) - %d 개";

    public OutputView() {
    }

    public static void printPublishedLottoResult(LottoTicketCount lottoTicketCount, PublishedLottoTicket publishedLottoTicket) {
        printLottoTicketCount(lottoTicketCount.getAutoLottoTicketCount(), lottoTicketCount.getManualLottoTicketCount());
        printLottoNumbers(publishedLottoTicket.getPublishedLottoTicket());
    }

    private static void printLottoTicketCount(int autoTicketCount, int manualTicketCount) {
        System.out.println(String.format(PURCHASED_LOTTO_TICKET_MESSAGE, autoTicketCount, manualTicketCount));
    }

    private static void printLottoNumbers(Set<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            List<Integer> sortedLottoNumbers = sortLottoNumber(lottoTicket.getLottoTicketNumbers());
            System.out.println(sortedLottoNumbers);
        }
        System.out.println();
    }

    private static List<Integer> sortLottoNumber(Set<LottoNumber> lottoNumbers) {
        List<Integer> sortedLottoNumbers = new ArrayList<>();
        lottoNumbers.stream().sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .forEach(lottoNumber -> sortedLottoNumbers.add(lottoNumber.getLottoNumber()));
        return sortedLottoNumbers;
    }

    public static void printLottoStatics(LottoResult lottoResult, BigDecimal prizeRate) {
        printWinningLottoResult(lottoResult.getLottoResult());
        printPrizeRate(prizeRate);
    }

    private static void printWinningLottoResult(Map<WinningPrize, Integer> lottoResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);

        lottoResult.entrySet().forEach(result -> {
            System.out.print(result.getKey().getMessage());
            System.out.println(String.format(DRAW_LOTTO_RESULT_MESSAGE, result.getKey().getPrize(), result.getValue()));
        });
        System.out.println();
    }

    private static void printPrizeRate(BigDecimal prizeRate) {
        System.out.print(String.format(TOTAL_RATE_OF_RETURN_MESSAGE, prizeRate));

        int prizeRateValue = prizeRate.intValue();
        if (prizeRateValue < AVERAGE_RATE_VALUE) {
           System.out.print(BAD_RATE_RESULT);
           return;
        }
        System.out.print(GOOD_RATE_RESULT);
    }
}
