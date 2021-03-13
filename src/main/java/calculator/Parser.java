package calculator;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String BASIC_DELIMITER_REGEX = "[,:]";

    public List<String> makeSequence(String expression) {
        return Arrays.asList(expression.split(BASIC_DELIMITER_REGEX));
    }

}
