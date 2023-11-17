package lotto.view;


import lotto.domain.Amount;

public class ResultView {
    private final static String PURCHASE_PRINT_DESCRIPTION = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    public static final String RETURN_RATE_DESCRIPTION = "총 수익률은 %.2f입니다.";
    private static final int LOTTO_AMOUNT = 1000;

    private ResultView() {
    }

    public static void purchaseCountPrint(final int manualLottoCount, final int purchaseAmount) {
        int autoCount = (int) (purchaseAmount - (manualLottoCount * LOTTO_AMOUNT)) / LOTTO_AMOUNT;
        System.out.println(String.format(PURCHASE_PRINT_DESCRIPTION, manualLottoCount, autoCount));
    }

    public static void print(final String text) {
        System.out.println(text);
    }

    public static void returnRatePrint(final double returnRate) {
        System.out.println(String.format(RETURN_RATE_DESCRIPTION, returnRate));
    }
}
