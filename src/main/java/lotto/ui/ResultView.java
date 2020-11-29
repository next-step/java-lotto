package lotto.ui;

import lotto.LottoTickets;
import lotto.Message;

public class ResultView {

    public static void output(LottoTickets lottoTickets) {
        printPurchaseNumber(lottoTickets);
        printLottoTicket(lottoTickets);
    }

    private static void printPurchaseNumber(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.size() + Message.OUTPUT_PURCHASE_COUNT_MESSAGE);
    }

    private static void printLottoTicket(LottoTickets lottoTickets) {
        for (int i = 0; i < lottoTickets.size(); i++) {
            System.out.println(lottoTickets.getLottoTicket(i).getTicket());
        }
    }
}
