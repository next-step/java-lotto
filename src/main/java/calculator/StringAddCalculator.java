package calculator;

import calculator.domain.InputValue;

import java.util.List;

public class StringAddCalculator {
    private static final int NUMBER_ZERO = 0;

    private List<Integer> separatedValues;

    public int splitAndSum(InputValue inputValue) {
        if (inputValue.isNullOrBlank()) {
            return NUMBER_ZERO;
        }

        if (inputValue.isOneLengthOnlyNumber()) {
            return Integer.parseInt(inputValue.getInputStringValue());
        }

        if (inputValue.isCommaOrColonSeparator()) {
            separatedValues = inputValue.getSeparatedValuesByCommaOrColon();
        }

        if (inputValue.isCustomSeparator()) {
            separatedValues = inputValue.getSeparatedValuesByCustom();
        }

        separatedValues.forEach(separatedValue -> {
            if (separatedValue < 0) {
                throw new RuntimeException("입력값으로 음수는 전달할 수 없습니다.");
            }
        });

        return separatedValues.stream()
                .mapToInt(value -> value).sum();
    }
}
