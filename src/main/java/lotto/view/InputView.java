package lotto.view;

public class InputView {

    private static final String PURCHASE_REQUEST_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";

    private InputView() {
    }

    public static void printPurchaseRequest() {
        System.out.println(PURCHASE_REQUEST_MESSAGE);
    }

    public static void printWinningNumbersRequest() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
    }
}
