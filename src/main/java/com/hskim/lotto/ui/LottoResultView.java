package com.hskim.lotto.ui;

public class LottoResultView {
    private static final String PURCHASE_NUMBER_PHRASE = "개를 구매했습니다.";
    private static final String STATISTIC_PHRASE = "당첨 통계";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String UNDER_LINE = "================";

    public void printString(String string) {
        System.out.println(string);
    }

    public void printPurchaseNum(String purchaseNum) {
        System.out.println(purchaseNum + PURCHASE_NUMBER_PHRASE);
    }

    public void printStatisticPhrase() {
        System.out.println(STATISTIC_PHRASE + NEW_LINE + UNDER_LINE);
    }
}
