package lotto.view;

import lotto.domain.NationalNumber;
import lotto.exception.InvalidInputException;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_QUANTITY_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INVALID_BLANK_STRING_MESSAGE = "공백은 입력이 불가합니다.";

    public static int inputPurchaseAmount() {
        String inputValue = getUserInputValue(INPUT_PURCHASE_AMOUNT_MESSAGE);
        validateInputString(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static int inputManualLottoQuantity() {
        String inputValue = getUserInputValue(INPUT_MANUAL_QUANTITY_MESSAGE);
        validateInputString(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static String[] inputManualNumbers(int manualQuantity) {
        String[] numbersArray = new String[manualQuantity];
        System.out.println(INPUT_MANUAL_NUMBERS_MESSAGE);
        for (int i = 0; i < manualQuantity; i++) {
            String manualNumbers = getUserInputValue(null);
            checkStringNumbers(manualNumbers);
            numbersArray[i] = manualNumbers;
        }
        return numbersArray;
    }

    public static String inputWinningNumbers() {
        String winningNumbers = getUserInputValue(INPUT_WINNING_NUMBERS_MESSAGE);
        checkStringNumbers(winningNumbers);
        return winningNumbers;
    }

    private static void checkStringNumbers(String numbers) {
        for (String number : numbers.split(",")) {
            validateInputString(number);
        }

    }

    public static String inputBonusNumber() {
        String inputValue = getUserInputValue(INPUT_BONUS_NUMBERS_MESSAGE);
        validateInputString(inputValue);
        return inputValue;
    }

    private static String getUserInputValue(String message) {
        if (message != null) {
            System.out.println(message);
        }
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
