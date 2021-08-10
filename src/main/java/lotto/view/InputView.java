package lotto.view;

import lotto.domain.NationalNumber;
import lotto.exception.InvalidInputException;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INVALID_BLANK_STRING_MESSAGE = "공백은 입력이 불가합니다.";

    public static int inputPurchaseAmount() {
        String inputValue = getUserInputValue(INPUT_PURCHASE_AMOUNT_MESSAGE);
        validateInputString(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static String inputWinningNumbers() {
        String winningNumbers = getUserInputValue(INPUT_WINNING_NUMBERS_MESSAGE).replace(" ", "");
        for (String number : winningNumbers.split(",")) {
            validateInputString(number);
        }
        return winningNumbers;
    }

    private static String getUserInputValue(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static void validateInputString(String input) {
        validateEmpty(input);
        NationalNumber.validateStrNumber(input);
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException(INVALID_BLANK_STRING_MESSAGE);
        }
    }
}
