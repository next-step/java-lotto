package step5.view;

import step5.domain.LottoNumber;
import step5.domain.lottoticket.LottoTicket;
import step5.domain.LottoTickets;
import step5.domain.Rank;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PURCHASE_LOTTO_INFO_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    private static final String LOTTO_RESULT_INFO_MESSAGE = "당첨 통계";
    private static final String LOTTO_RESULT_INFO_SEPARATOR = "---------";
    private static final String WINNING_LOTTO_RESULT = "%s개 일치 (%s원)- %s개";

    public static void printPurchaseLottoInfo(Integer numberOfManualLottoTicketPurchased,
        int numberOfAutoLottoTicketPurchased) {
        System.out.printf(PURCHASE_LOTTO_INFO_MESSAGE, numberOfManualLottoTicketPurchased,
            numberOfAutoLottoTicketPurchased);
        System.out.println();
    }


    public static void printLottoNumberInfo(LottoTickets lottoTickets) {
        lottoTickets.tickets()
            .stream()
            .map(ResultView::printByTicket)
            .forEach(System.out::println);
    }

    private static String printByTicket(LottoTicket lottoTicket) {
        return lottoTicket.ticket()
            .stream()
            .map(ResultView::printByNumber)
            .collect(Collectors.joining(", ", "[", "]"));
    }

    private static String printByNumber(LottoNumber lottoNumber) {
        return Integer.toString(lottoNumber.number());
    }


    public static void printResult(Map<Rank, Integer> result, Integer totalPrice) {
        System.out.println(LOTTO_RESULT_INFO_MESSAGE);
        System.out.println(LOTTO_RESULT_INFO_SEPARATOR);
        int totalPrize = 0;
        for (Rank rank : result.keySet()) {
            System.out.printf(WINNING_LOTTO_RESULT, rank.getCountOfMatch(), rank.getWinningMoney(),
                result.get(rank));
            totalPrize += rank.getWinningMoney() * result.get(rank);
            System.out.println();
        }
        printYield(totalPrize, totalPrice);
    }

    private static void printYield(int totalPrize, int totalPrice) {
        if (totalPrize > totalPrice) {
            System.out.printf("총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 이득이라는 의미임)",
                totalPrize / (double) totalPrice);
            return;
        }
        if (totalPrize < totalPrice) {
            System.out.printf("총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)",
                totalPrize / (double) totalPrice);
            return;
        }
        System.out.printf("총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 본전이라는 의미임)",
            totalPrize / (double) totalPrice);
    }
}
