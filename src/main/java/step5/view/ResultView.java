package step5.view;

public class ResultView {
    private static final String PURCHASE_LOTTO_INFO_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    public static void printPurchaseLottoInfo(Integer numberOfManualLottoTicketPurchased, int numberOfAutoLottoTicketPurchased) {
        System.out.printf(PURCHASE_LOTTO_INFO_MESSAGE, numberOfManualLottoTicketPurchased, numberOfAutoLottoTicketPurchased);
    }
}
