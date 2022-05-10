package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;

public class OutputView {
    private static final StringBuilder stringBuilder = new StringBuilder();

    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchaseLotto(PurchaseAmount purchaseAmount) {
        stringBuilder.append(purchaseAmount.getAmount())
                .append(PURCHASE_COUNT_MESSAGE);

        System.out.println(stringBuilder);
        initStringBuilder();
    }

    public static void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    private static void initStringBuilder() {
        stringBuilder.setLength(0);
    }

}
