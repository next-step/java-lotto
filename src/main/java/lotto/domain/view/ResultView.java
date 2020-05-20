package lotto.domain.view;

public class ResultView {

    private final static String TICKET_PURCHASE_CONFIRM_MESSAGE = "%d개를 구입했습니다.";

    public static void printPurchasedTicketCount(final int count) {
        System.out.println(String.format(TICKET_PURCHASE_CONFIRM_MESSAGE, count));
    }
}
