package lotto.view;

public class OutputView {

    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void showPurchaseCount(int count) {
        System.out.println(count + PURCHASE_MESSAGE);
    }
}
