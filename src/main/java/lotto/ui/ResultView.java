package lotto.ui;

import lotto.LottoTickets;

public class ResultView {

    private static final String MESSAGE = "개를 구매했습니다.";

    public static void output(LottoTickets lottoTickets) {
        printPurchaseNumber(lottoTickets);
        printLottoTicket(lottoTickets);
    }

    private static void printPurchaseNumber(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.size() + MESSAGE);
    }

    private static void printLottoTicket(LottoTickets lottoTickets) {
        for (int i = 0; i < lottoTickets.size(); i++) {
            System.out.println(lottoTickets.getLottoTicket(i).getTicket());
        }
    }
}
