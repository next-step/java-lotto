package com.hskim.lotto.ui;

import com.hskim.lotto.model.PurchasePrice;

import java.util.Scanner;

/**
 * Created by hs kim on 2020/08/14
 */
public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_PHRASE = "구입금액을 입력해 주세요.";

    public void printPurchasePhrase() {
        System.out.println(PURCHASE_PHRASE);
    }

    public PurchasePrice getPurchasePriceFromInput() {
        return new PurchasePrice(scanner.nextLine());
    }

    public void printPurchaseResult() {

    }
}
