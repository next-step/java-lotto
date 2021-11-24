package lotto.view;

import java.text.MessageFormat;
import lotto.LottoTicket;
import lotto.LottoTickets;

public class OutputView {

    public static void printBuyCountMessage(LottoTickets lottoTickets) {
        System.out.println(MessageFormat.format("{0}개를 구매했습니다.", lottoTickets.getTicketSize()));

        lottoTickets.getTickets().stream()
            .map(LottoTicket::getNumbersToString)
            .forEach(System.out::println);

        System.out.println();
    }

}
