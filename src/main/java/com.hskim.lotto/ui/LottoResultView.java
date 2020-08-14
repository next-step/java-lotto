package com.hskim.lotto.ui;

public class LottoResultView {
    private static final String PURCHASE_NUMBER_PHRASE = "개를 구매했습니다.";

    public void printString(String string) {
        System.out.println(string);
    }

    public void printPurchaseNum(String purchaseNum) {
        System.out.println(purchaseNum + PURCHASE_NUMBER_PHRASE);
    }
}
