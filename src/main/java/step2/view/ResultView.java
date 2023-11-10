package step2.view;

public class ResultView {

    private static final String PURCHASE_MESSAGE = "%s개를 구매했습니다.";

    public static void printPurchaseMessage(int count) {
        System.out.println(String.format(PURCHASE_MESSAGE, count));
    }

}
