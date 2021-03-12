package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    private static final String BASIC_DELIMITER_REGEX = "[,:]";

    public int sum(String expression) {
        List<String> sequence = Arrays.asList(expression.split(BASIC_DELIMITER_REGEX));

        return sequence.stream().mapToInt(Integer::parseInt).sum();
    }

}
