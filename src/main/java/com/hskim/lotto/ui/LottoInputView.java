package com.hskim.lotto.ui;

import com.hskim.lotto.model.LottoWinningTicket;
import com.hskim.lotto.model.PurchasePrice;

import java.util.Arrays;
import java.util.Scanner;

public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_PHRASE = "구입금액을 입력해 주세요.";
    private static final String WIN_PHRASE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_DELIMITER = ",";
    private static final String NEW_LINE = System.lineSeparator();

    public void printPurchasePhrase() {
        System.out.println(PURCHASE_PHRASE);
    }

    public PurchasePrice getPurchasePriceFromInput() {
        return new PurchasePrice(scanner.nextLine());
    }

    public void printWinPhrase() {
        System.out.println(NEW_LINE + WIN_PHRASE);
    }

    public LottoWinningTicket getWinningTicket() {
        String[] inputs = scanner.nextLine()
                .split(INPUT_DELIMITER);
        return new LottoWinningTicket(Arrays.asList(inputs));
    }
}
