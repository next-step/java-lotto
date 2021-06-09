package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Word {
    private static final String SEPARATOR = "[,:]";
    private static final String IS_NUMBER = "[0-9]";
    private static final int CUSTOM_LETTER_INDEX = 2;
    private static final String NEGATIVE_NUMBER_MESSAGE = "음수가 입력 되었습니다.";

    public List<String> makeNumbers(String expression) {
        return Arrays.asList(expression.split(SEPARATOR));
    }

    public boolean isCustomInput(String expression) {
        String[] inputs = expression.split("");
        return !inputs[0].equals(IS_NUMBER);
    }

    public List<String> customSeparate(String customExpression) {
        return Arrays.asList(customExpression.split(""));
    }

    public String findCustomSeparator(String customExpression) {
        return customSeparate(customExpression).get(CUSTOM_LETTER_INDEX);
    }

    public void validation(List<String> numbers) {

        List<Integer> intNumbers = new ArrayList();
        for (String number : numbers) {
            intNumbers.add(Integer.parseInt(number));
        }
        if (Collections.min(intNumbers) < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_MESSAGE);
        }
    }

    public boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }
}
