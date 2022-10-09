package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.NotAValidInputException;
import exception.NullAndEmptyException;

public class InputValidation {

    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private static final String FOUR_RULES_SYMBOLS = "[\\+\\*\\/\\-]";
    private static final int EMPTY_SIZE_VALUE = 0;
    private static final int SINGLE_SIZE_VALUE = 1;

    public String[] validationInputValues(String[] input) {

        validateNullAndEmpty(input);

        validateSymbolAndNumber(input);

        validateFirstLastInputValue(input);

        return input;
    }

    private void validateNullAndEmpty(String[] input) {

        if (input == null || input.length == EMPTY_SIZE_VALUE) {
            throw new NullAndEmptyException("빈 값이 입력되었습니다. 값을 입력하세요");
        }

        if (input.length == SINGLE_SIZE_VALUE && input[0].isEmpty()) {
            throw new NullAndEmptyException("빈 값이 입력되었습니다. 값을 입력하세요");
        }

    }

    private void validateSymbolAndNumber(String[] input) {
        List<String> existNotValidElements = Arrays.stream(input)
            .filter(it -> !it.matches(FOUR_RULES_SYMBOLS))
            .filter(it -> !it.matches(NUMBER_PATTERN))
            .collect(Collectors.toList());

        if (!existNotValidElements.isEmpty()) {
            throw new NotAValidInputException("숫자와 사칙기호만 입력하세요");
        }
    }

    private void validateFirstLastInputValue(String[] input) {

        boolean checkFirstElement = input[0].matches(NUMBER_PATTERN);
        boolean checkLastElement = input[input.length - 1].matches(NUMBER_PATTERN);

        if (!checkFirstElement) {
            throw new NotAValidInputException("첫번째값은 무조건 숫자가 입력되어야 합니다.");
        }

        if (!checkLastElement) {
            throw new NotAValidInputException("마지막값은 무조건 숫자가 입력되어야 합니다.");
        }
    }
}
