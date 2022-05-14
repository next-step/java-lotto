package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.List;

public class OutputView {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final String LEFT_BRACE = "[";
    private static final String RIGHT_BRACE = "]";

    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LINE_BREAK = "\n";

    public static void printPurchaseLotto(int amount) {
        stringBuilder.append(amount)
                .append(PURCHASE_COUNT_MESSAGE)
                .append(LINE_BREAK);

        System.out.println(stringBuilder);
        initStringBuilder();
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            stringBuilder.append(LEFT_BRACE);
            stringBuilder.append(lottoNumbers.toString());
            stringBuilder.append(RIGHT_BRACE);
            System.out.println(stringBuilder);
            initStringBuilder();
        }
    }

    private static void initStringBuilder() {
        stringBuilder.setLength(0);
    }
}
