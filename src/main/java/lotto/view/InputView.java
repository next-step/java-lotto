package lotto.view;

import lotto.exception.InvalidUserInputException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final String NUMBER_REG_EXP = "^[0-9]+$";
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String COUNT_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String INVALID_BLANK_STRING_MESSAGE = "공백은 입력이 불가합니다.";
    private static final String INVALID_STRING_MESSAGE = "숫자만 입력 가능합니다.";

    public static int inputPurchaseAmount() {
        return Integer.parseInt(getUserInputValue(INPUT_PURCHASE_AMOUNT_MESSAGE));
    }

    private static String getUserInputValue(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String inputValue = sc.nextLine();

        validateInputString(inputValue);

        return inputValue;
    }

    private static void validateInputString(String input) {
        validateEmpty(input);
        validateNumber(input);
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidUserInputException(INVALID_BLANK_STRING_MESSAGE);
        }
    }

    private static void validateNumber(String strNumber) {
        if (!Pattern.compile(NUMBER_REG_EXP).matcher(strNumber).find()) {
            throw new InvalidUserInputException(INVALID_STRING_MESSAGE);
        }
    }

}
