package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Word {
    private static final String SEPARATOR = "[,:]";
    private static final String ONLY_NUMBER_REGEX = "[0-9]";
    private static final String NOT_NUMBER_REGEX = "[^0-9]";
    private static final int POSITIVE_NUMBER = 0;
    private static final int FIRST_INDEX = 0;
    private static final int CUSTOM_LETTER_INDEX = 2;
    private static final String NEGATIVE_NUMBER_MESSAGE = "음수가 입력 되었습니다.";

    public List<Integer> makeNumbersInGeneralExpression(String expression) {
        List<String> stringExpressions = Arrays.asList(expression.split(SEPARATOR));
        List<Integer> numbers = new ArrayList<>();
        for (String expressions : stringExpressions) {
            numbers.add(Integer.parseInt(expressions));
        }
        return numbers;
    }

    public List<Integer> makeNumbersInCustomExpression(String customExpressions) {
        customExpressions = customExpressions.replaceAll(NOT_NUMBER_REGEX, " ");
        List<String> stringExpressions = Arrays.asList(customExpressions.trim().split(" "));
        List<Integer> numbers = new ArrayList<>();
        for (String expressions : stringExpressions) {
            numbers.add(Integer.parseInt(expressions));
        }
        return numbers;
    }

    public boolean isCustomInput(String expression) {
        String[] inputs = expression.split("");
        if (inputs[FIRST_INDEX].matches(ONLY_NUMBER_REGEX)) {
            return false;
        }
        return true;
    }

    public String findCustomSeparator(String customExpression) {
        return Arrays.asList(customExpression.split("")).get(CUSTOM_LETTER_INDEX);
    }

    public void validation(List<Integer> numbers) {
        if (Collections.min(numbers) < POSITIVE_NUMBER) {
            throw new RuntimeException(NEGATIVE_NUMBER_MESSAGE);
        }
    }

    public boolean isEmptyOrNull(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }
}
