package lotto.auto.io;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

public final class InputView {
    private static final String DELIMITER = ", ";
    private static final String INPUT_PAYMENT_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPayment() {
        println(INPUT_PAYMENT_MESSAGE);
        return parseInt(SCANNER.nextLine().trim());
    }

    public static int[] inputWinningNumbers() {
        println(INPUT_WINNING_NUMBERS_MESSAGE);
        return stream(SCANNER.nextLine()
                             .trim()
                             .split(DELIMITER)
                     )
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void println(String string) {
        System.out.println(string);
    }
}
