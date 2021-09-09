package step5.view;

import step5.domain.LottoNumber;
import step5.domain.LottoTicket;
import step5.domain.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASE_LOTTO_INFO_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    public static void printPurchaseLottoInfo(Integer numberOfManualLottoTicketPurchased, int numberOfAutoLottoTicketPurchased) {
        System.out.printf(PURCHASE_LOTTO_INFO_MESSAGE, numberOfManualLottoTicketPurchased, numberOfAutoLottoTicketPurchased);
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


}
