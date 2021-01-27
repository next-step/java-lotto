package lotto.view;

public class ResultView {
    private static final String PURCHASE_NUMBER_MESSAGE = "개를 구입했습니다.";

    public static void printPurchaseNumber(int number) {
        System.out.println(number + PURCHASE_NUMBER_MESSAGE);
        return;
    }
}
