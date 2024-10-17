package calculator;

import java.util.Arrays;
import java.util.List;

public class SpaceExpressionTokenizer implements ExpressionTokenizer {

    private static final String SPLIT_PATTERN = " ";

    @Override
    public List<String> tokenize(String input) {
        return toList(split(input));
    }

    private String[] split(String input) {
        return input.split(SPLIT_PATTERN);
    }

    private List<String> toList(String[] value){
        return Arrays.asList(value);
    }
}
