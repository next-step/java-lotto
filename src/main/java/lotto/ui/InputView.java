package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public final class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PRICE_QUESTION_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String WINNER_NUMBERS_QUESTION_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_QUESTION_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String BLANK_MESSAGE = "입력하신 값이 비어있습니다.";
    private static final String NOT_AN_INTEGER_MESSAGE = "입력하신 값이 정수가 아닙니다.";
    private static final String NOT_A_POSITIVE_NUMBER_MESSAGE = "입력하신 값이 양의 정수가 아닙니다.";
    private static final String NOT_A_VALID_LOTTO_NUMBER_MESSAGE = "입력하신 값이 로또 숫자에 적합하지 않습니다.";
    private static final String WINNER_NUMBERS_INPUT_DELIMITER = ", ";

    public static int priceInput() {
        return input(PRICE_QUESTION_MESSAGE, InputView::isNumberInputValid, InputView::convertToNumber);
    }

    public static int manualLottoCountInput() {
        return input(MANUAL_LOTTO_COUNT_MESSAGE, InputView::isNumberInputValid, InputView::convertToNumber);
    }

    public static int bonusNumberInput() {
        return input(BONUS_NUMBER_QUESTION_MESSAGE, InputView::isNumberInputValid, InputView::convertToNumber);
    }

    public static List<Integer> winnerNumbersInput() {
        return input(WINNER_NUMBERS_QUESTION_MESSAGE, InputView::isWinnerNumbersInputValid, InputView::convertToWinnerNumbers);
    }

    private static boolean isNumberInputValid(String rawInput) {
        if (rawInput.isEmpty()) {
            System.out.println(BLANK_MESSAGE);
            return false;
        }
        int numberInput;
        try {
            numberInput = Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            System.out.println(NOT_AN_INTEGER_MESSAGE);
            return false;
        }
        if (numberInput <= 0) {
            System.out.println(NOT_A_POSITIVE_NUMBER_MESSAGE);
            return false;
        }
        return true;
    }

    private static Integer convertToNumber(String rawInput) {
        return Integer.parseInt(rawInput);
    }

    private static boolean isWinnerNumbersInputValid(String rawInput) {
        if (rawInput == null || rawInput.isEmpty()) {
            System.out.println(BLANK_MESSAGE);
            return false;
        }
        List<String> numberStrings = List.of(rawInput.split(WINNER_NUMBERS_INPUT_DELIMITER));
        boolean isNumberInputsValid = true;
        for (String numberString : numberStrings) {
            isNumberInputsValid = isNumberInputsValid && isNumberInputValid(numberString);
        }
        if (!isNumberInputsValid) {
            System.out.println(NOT_A_VALID_LOTTO_NUMBER_MESSAGE);
            return false;
        }

        return true;
    }

    private static List<Integer> convertToWinnerNumbers(String rawInput) {
        List<String> numberStrings = List.of(rawInput.split(WINNER_NUMBERS_INPUT_DELIMITER));
        List<Integer> winnerNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            winnerNumbers.add(Integer.parseInt(numberString));
        }
        return winnerNumbers;
    }

    private static <T> T input(String questionMessage, Function<String, Boolean> inputValidationFunction, Function<String, T> convertInputFunction) {
        boolean hasValidInput = false;
        T input = null;
        while (!hasValidInput) {
            System.out.println(questionMessage);
            String rawInput = SCANNER.nextLine();
            hasValidInput = inputValidationFunction.apply(rawInput);
            input = convertInputFunction.apply(rawInput);
        }
        return input;
    }
}
