package lotto.view;

import lotto.model.Lotto;

public class ResultView {
    private static final String CHECK_PURCHASE = "개를 구매했습니다.";

    public static void printCheckPurchaseMessage(int purchaseAmount) {
        System.out.println(String.valueOf(purchaseAmount) + CHECK_PURCHASE);
    }

    public static void printLottoTicket(Lotto ticket) {
        System.out.println(ticket.numbers());
    }
}
