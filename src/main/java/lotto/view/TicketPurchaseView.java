package lotto.view;

import lotto.util.ScannerUtils;

public class TicketPurchaseView {

    private TicketPurchaseView() {
    }

    public static Integer buyTicket() {
        System.out.println("구입금액을 입력해 주세요.");
        return ScannerUtils.nextInt();
    }

}
