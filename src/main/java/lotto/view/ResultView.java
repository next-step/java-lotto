package lotto.view;


public class ResultView {
    private final static String PURCHASE_PRINT_DESCRIPTION = "개를 구매했습니다.";
    public static void purchaseCountPrint(final int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_PRINT_DESCRIPTION);
    }

    public static void print(final String text) {
        System.out.println(text);
    }
}
