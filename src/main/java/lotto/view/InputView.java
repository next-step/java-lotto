package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final String INPUT_IS_EMPTY_ERROR_LOG = "공백은 들어올 수 없습니다.";
    private static final String LOTTO_NUMBER_SIZE_ERROR_LOG = "로또는 6자리여야 합니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;

    public static String[] writeWinningNumbers() {
        String input = scanner.nextLine();
        checkEmptyString(input);

        String[] numbers = makeStringToArray(input);
        checkSixNumbers(numbers);
        return numbers;
    }

    private static String[] makeStringToArray(String input) {
        return input.split(DELIMITER);
    }

    private static void checkEmptyString(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY_ERROR_LOG);
        }
    }

    private static void checkSixNumbers(String[] input) {
        if (input.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_LOG);
        }
    }
}
