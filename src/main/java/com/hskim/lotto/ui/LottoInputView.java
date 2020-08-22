package com.hskim.lotto.ui;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private static final String PURCHASE_PHRASE = "구입금액을 입력해 주세요.";
    private static final String WIN_PHRASE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_PHRASE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_TICKETING_NUM_PHRASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_TICKETING_PHRASE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_DELIMITER = ",";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String WHITE_SPACE_REGEX = "\\s+";
    private static final String BLANK_STRING = "";
    private static final Scanner scanner = new Scanner(System.in);

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

    public List<Integer> getTicketNumbers() {
        return Arrays.stream(scanner.nextLine()
                .replaceAll(WHITE_SPACE_REGEX, BLANK_STRING)
                .split(INPUT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void printBonusBallPhrase() {
        System.out.println(BONUS_BALL_PHRASE);
    }

    public int getBonusNumber() {
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();

        return bonusNumber;
    }

    public void printManualTicketingNumPhrase() {
        System.out.println(NEW_LINE + MANUAL_TICKETING_NUM_PHRASE);
    }

    public void printManualTicketingPhrase() {
        System.out.println(NEW_LINE + MANUAL_TICKETING_PHRASE);
    }

    public int getManualTicketingNum() {
        int ticketingNum = scanner.nextInt();
        scanner.nextLine();

        return ticketingNum;
    }

    public List<List<Integer>> getManualLottoNumbersList(int manualTicketingNum) {
        List<List<Integer>> result = new LinkedList<>();
        for (int index = 0; index < manualTicketingNum; index++) {
            result.add(getTicketNumbers());
        }

        return result;
    }

}
