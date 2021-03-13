package calculator;

import java.util.Arrays;

public class Parser {

    private static final String BASIC_DELIMITER_REGEX = "[,:]";

    public Sequence makeSequence(String expression) {
        return new Sequence(Arrays.asList(expression.split(BASIC_DELIMITER_REGEX)));
    }

}
