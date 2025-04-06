package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INVALID_INTEGER_INPUT_MESSAGE = "정수를 입력해주세요.";
    private static final String INVALID_STRING_INPUT_MESSAGE = "입력 값이 null 이거나 빈 문자열 입니다.";
    private final Scanner scanner = new Scanner(System.in);

    public int getPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        return getIntegerInput();
    }

    public String getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return getStringInput();
    }

    public int getBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return getIntegerInput();
    }

    private int getIntegerInput() {
        validateIntegerInput();
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private String getStringInput() {
        String input = scanner.nextLine();
        validateStringInput(input);
        return input;
    }

    private void validateIntegerInput() {
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            throw new IllegalArgumentException(INVALID_INTEGER_INPUT_MESSAGE);
        }
    }

    private void validateStringInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_STRING_INPUT_MESSAGE);
        }
    }

}
