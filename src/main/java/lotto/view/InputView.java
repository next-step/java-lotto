package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String PURCHASE_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchasePrice() {
        return inputInt(PURCHASE_PRICE_MESSAGE);
    }

    public static String inputWinningNumbers() {
        return inputString(WINNING_NUMBERS_MESSAGE);
    }

    private static String inputString(final String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

    private static int inputInt(final String message) {
        System.out.println(message);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
