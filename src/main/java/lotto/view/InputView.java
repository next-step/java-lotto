package lotto.view;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {
    private static final String INPUT_PAYMENT_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPayment() {
        println(INPUT_PAYMENT_MESSAGE);
        return parseInt(SCANNER.nextLine().trim());
    }

    public static String inputWinningNumbers() {
        println(INPUT_WINNING_NUMBERS_MESSAGE);
        return SCANNER.nextLine().trim();

    }

    private static void println(String string) {
        System.out.println(string);
    }
}
