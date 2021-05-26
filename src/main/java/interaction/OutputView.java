package interaction;

public class OutputView {

    private static final String PURCHASE_COUNT_RESULT_MESSAGE = "개를 구매했습니다\n";

    private OutputView() {

    }

    public static void purchaseCountResult(int purchaseCount) {
        System.out.print(purchaseCount);
        System.out.print(PURCHASE_COUNT_RESULT_MESSAGE);
    }

    public static void sendMessage(String message) {
        System.out.println(message);
    }
}
