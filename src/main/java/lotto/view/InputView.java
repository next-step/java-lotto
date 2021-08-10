package lotto.view;

import lotto.exception.InvalidInputException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final String NUMBER_REG_EXP = "^[0-9]+$";
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INVALID_BLANK_STRING_MESSAGE = "공백은 입력이 불가합니다.";
    private static final String INVALID_STRING_MESSAGE = "숫자만 입력 가능합니다.";

    public static int inputPurchaseAmount() {
        String inputValue = getUserInputValue(INPUT_PURCHASE_AMOUNT_MESSAGE);
        validateInputString(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static String inputWinningNumbers() {
        String winningNumbers = getUserInputValue(INPUT_WINNING_NUMBERS_MESSAGE);
        for (String number : winningNumbers.split(",")) {
            validateInputString(number);
        }
        return winningNumbers;
    }

    private static String getUserInputValue(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String inputValue = sc.nextLine();

        return inputValue;
    }

    private static void validateInputString(String input) {
        validateEmpty(input);
        validateNumber(input);
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException(INVALID_BLANK_STRING_MESSAGE);
        }
    }

    private static void validateNumber(String strNumber) {
        if (!Pattern.compile(NUMBER_REG_EXP).matcher(strNumber).find()) {
            throw new InvalidInputException(INVALID_STRING_MESSAGE);
        }
    }
}
