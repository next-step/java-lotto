package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Word {
    private static final String SEPARATOR = "[,:]";
    private static final String ONLY_NUMBER_REGEX = "[0-9]";
    private static final String NOT_NUMBER_REGEX = "[^0-9-]";
    private static final int POSITIVE_NUMBER = 0;
    private static final int FIRST_INDEX = 0;
    private static final int CUSTOM_LETTER_INDEX = 2;
    private static final String NEGATIVE_NUMBER_MESSAGE = "음수가 입력 되었습니다.";
    private static final Pattern ONLY_NUMBER_REGEX_PATTERN = Pattern.compile(ONLY_NUMBER_REGEX);

    public List<Integer> makeNumbers(String expression) {
        if (isCustomInput(expression)) {
            return convertExpressionsToNumbers(makeNumbersInCustomExpression(expression));
        }
        return convertExpressionsToNumbers(makeNumbersInGeneralExpression(expression));
    }

    private List<String> makeNumbersInCustomExpression(String customExpressions) {
        customExpressions = customExpressions.replaceAll(NOT_NUMBER_REGEX, " ");

        return Arrays.asList(customExpressions.trim().split(" "));
    }

    private List<String> makeNumbersInGeneralExpression(String expression) {
        return Arrays.asList(expression.split(SEPARATOR));
    }

    List<Integer> convertExpressionsToNumbers(List<String> stringExpressions) {
        List<Integer> numbers = stringExpressions.stream()
                .map((string) -> Integer.parseInt(string))
                .collect(Collectors.toList());

        notNegativeValidation(numbers);

        return numbers;
    }

    public boolean isCustomInput(String expression) {
        String[] inputs = expression.split("");
        isEmptyOrNull(expression);

        return !(ONLY_NUMBER_REGEX_PATTERN.matcher(inputs[FIRST_INDEX]).matches());
    }

    public String findCustomSeparator(String customExpression) {
        isEmptyOrNull(customExpression);
        return customExpression.split("")[CUSTOM_LETTER_INDEX];
    }

    public void notNegativeValidation(List<Integer> numbers) {
        if (Collections.min(numbers) < POSITIVE_NUMBER) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE);
        }
    }

    public void isEmptyOrNull(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("입력이 NULL 이거나 없습니다.");
        }
    }
}
