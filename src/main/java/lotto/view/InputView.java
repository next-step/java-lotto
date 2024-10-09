package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int MINIMUM_VALUE = 0;
    private static final int WINNING_LOTTO_COUNT_SIZE = 6;
    private static final String REGEX = ",";
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INCORRECT_VALUE_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String INCORRECT_RANGE_ERROR_MESSAGE = MINIMUM_VALUE + "보다 낮은 수는 입력할 수 없습니다.";
    private static final String INCORRECT_WINNING_NUMBER_COUNT = "당첨번호는 6개입니다.";
    private static final String DUPLICATED_WINNING_NUMBER_ERROR_MESSAGE = "당첨번호에 중복된 번호가 존재합니다.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public InputView() {
    }

    public static String inputValue() {
        return SCANNER.nextLine();
    }

    public static int getPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        String inputValue = inputValue();
        validatePurchasePrice(inputValue);
        return Integer.parseInt(inputValue);
    }

    private static void validatePurchasePrice(final String inputValue) {
        validateNumberValue(inputValue);
        validateRange(inputValue);
    }

    private static void validateNumberValue(final String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INCORRECT_VALUE_ERROR_MESSAGE);
        }
    }

    private static void validateRange(final String inputValue) {
        int value = Integer.parseInt(inputValue);
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException(INCORRECT_RANGE_ERROR_MESSAGE);
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        String inputValue = inputValue();
        List<String> values = List.of(inputValue.split(REGEX));
        validateWinningNumber(values);
        return convertToIntList(values);
    }

    private static void validateWinningNumber(final List<String> values) {
        validateCount(values);
        for (String value : values) {
            validateNumberValue(value);
        }
        validateDuplicated(values);
    }

    private static void validateCount(final List<String> values) {
        if (values.size() != WINNING_LOTTO_COUNT_SIZE) {
            throw new IllegalArgumentException(INCORRECT_WINNING_NUMBER_COUNT);
        }
    }

    private static List<Integer> convertToIntList(final List<String> inputValues) {
        return inputValues.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateDuplicated(final List<String> inputValues) {
        if (inputValues.size() != inputValues.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }
}
