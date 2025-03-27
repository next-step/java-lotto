package utils;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public String inputExpression() {
        return scanner.nextLine();
    }

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
