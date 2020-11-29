package lotto.ui;

import lotto.LottoTickets;
import lotto.Message;

import java.util.List;

public class ResultView {

    private static final String THREE_MATCHING_WINNINGS_AMOUNT_MESSAGE = "3개 일치 (5,000원)- ";
    private static final String FOUR_MATCHING_WINNINGS_AMOUNT_MESSAGE = "4개 일치 (50,000원)- ";
    private static final String FIVE_WINNINGS_AMOUNT_MESSAGE = "5개 일치 (1,500,000원)- ";
    private static final String SIX_WINNINGS_AMOUNT_MESSAGE = "6개 일치 (2,000,000,000원)- ";

    public static void outputPrintPurchaseLottoTicket(LottoTickets lottoTickets) {
        printPurchaseCount(lottoTickets);
        printPurchaseLottoTicket(lottoTickets);
    }

    private static void printPurchaseCount(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.size() + Message.OUTPUT_PURCHASE_COUNT_MESSAGE);
    }

    private static void printPurchaseLottoTicket(LottoTickets lottoTickets) {
        for (int i = 0; i < lottoTickets.size(); i++) {
            System.out.println(lottoTickets.getLottoTicket(i).getTicket());
        }
    }

    public static void outputWinningStatistic(List<Integer> lastWeeksWinningNumbers, double rateOfReturn) {
        printWinningsStatisticsMessage();
        printWinningsCount(lastWeeksWinningNumbers);
        printRateOfReturn(rateOfReturn);
    }


    private static void printWinningsStatisticsMessage() {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("=======");
    }

    private static void printWinningsCount(List<Integer> lastWeeksWinningNumbers) {
        System.out.println(THREE_MATCHING_WINNINGS_AMOUNT_MESSAGE + lastWeeksWinningNumbers.get(0));
        System.out.println(FOUR_MATCHING_WINNINGS_AMOUNT_MESSAGE + lastWeeksWinningNumbers.get(1));
        System.out.println(FIVE_WINNINGS_AMOUNT_MESSAGE + lastWeeksWinningNumbers.get(2));
        System.out.println(SIX_WINNINGS_AMOUNT_MESSAGE + lastWeeksWinningNumbers.get(3));
    }

    private static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
