package step2.view;

import step2.model.PurchasedLottoTickets;

public class OutputView {

    private static final String SHOW_FORMAT_PURCHASED_COUNT = "%d개를 구매했습니다.";

    public static void printLottoTicket(PurchasedLottoTickets purchasedLottoTickets) {
        System.out.println(String.format(SHOW_FORMAT_PURCHASED_COUNT, purchasedLottoTickets.size()));
        System.out.println(purchasedLottoTickets.toString());
        System.out.println();
    }
}
