package lotto.step2.view;

public class ResultView {

    private static final String PURCHASE_MSG = "개를 구매했습니다.";

    private ResultView() {
    }

    public static void printPurchaseAmount(int amount) {
        System.out.println(amount + PURCHASE_MSG);
    }
}
