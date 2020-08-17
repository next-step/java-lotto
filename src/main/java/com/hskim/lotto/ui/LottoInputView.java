package com.hskim.lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_PHRASE = "구입금액을 입력해 주세요.";
    private static final String WIN_PHRASE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_DELIMITER = ",";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String WHITE_SPACE_REGEX = "\\s+";
    private static final String BLANK_STRING = "";

    public void printPurchasePhrase() {
        System.out.println(PURCHASE_PHRASE);
    }

    public int getPurchasePriceFromInput() {
        int purchasePrice = scanner.nextInt();
        scanner.nextLine();

        return purchasePrice;
    }

    public void printWinPhrase() {
        System.out.println(NEW_LINE + WIN_PHRASE);
    }

    public List<Integer> getWinningTicketNumbers() {
        return Arrays.stream(scanner.nextLine()
                .replaceAll(WHITE_SPACE_REGEX, BLANK_STRING)
                .split(INPUT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
