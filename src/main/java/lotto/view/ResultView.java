package lotto.view;

public class ResultView {
    private static final String PRINT_PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public ResultView() {
    }

    public static void printPurchaseLottoCount(final int lottoCount) {
        System.out.printf(PRINT_PURCHASE_LOTTO_COUNT_MESSAGE, lottoCount);
    }
}
