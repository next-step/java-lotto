package lotto.view;


import lotto.domain.Amount;
import lotto.domain.Rank;
import lotto.domain.Winning;

import java.math.BigDecimal;

public class ResultView {
    private final static String PURCHASE_PRINT_DESCRIPTION = "개를 구매했습니다.";
    public static final String RETURN_RATE_DESCRIPTION = "총 수익률은 %.2f입니다.";

    private ResultView() {
    }

    public static void purchaseCountPrint(final int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_PRINT_DESCRIPTION);
    }

    public static void print(final String text) {
        System.out.println(text);
    }

    public static void returnRatePrint(final double returnRate) {
        System.out.println(String.format(RETURN_RATE_DESCRIPTION, returnRate));
    }
}
