package lotto.view;


import lotto.domain.Amount;

public class ResultView {
    private final static String PURCHASE_PRINT_DESCRIPTION = "수동으로 %.0f장, 자동으로 %.0f개를 구매했습니다.";
    public static final String RETURN_RATE_DESCRIPTION = "총 수익률은 %.2f입니다.";

    private ResultView() {
    }

    public static void purchaseCountPrint(final Amount manualLottoCount, final Amount purchaseAmount) {
        final Amount totalCount = Amount.of((int) purchaseAmount.divide(Amount.lotto()).get());
        final Amount autoCount = totalCount.minus(manualLottoCount);
        System.out.println(String.format(PURCHASE_PRINT_DESCRIPTION, manualLottoCount.get(), autoCount.get()));
    }

    public static void print(final String text) {
        System.out.println(text);
    }

    public static void returnRatePrint(final double returnRate) {
        System.out.println(String.format(RETURN_RATE_DESCRIPTION, returnRate));
    }
}
