package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final String INPUT_IS_EMPTY_ERROR_LOG = "공백은 들어올 수 없습니다.";

    public static String[] writeWinningNumbers() {
        String input = scanner.nextLine();
        checkEmptyString(input);
        return makeStringToArray(input);
    }

    private static String[] makeStringToArray(String input) {
        return input.split(DELIMITER);
    }

    private static void checkEmptyString(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY_ERROR_LOG);
        }
    }
}
