package calculator;

import java.util.Arrays;
import java.util.List;

public class SpaceExpressionTokenizer implements ExpressionTokenizer {

    @Override
    public List<String> tokenize(String input) {
        return toList(split(input));
    }

    private String[] split(String input) {
        return input.split(" ");
    }

    private List<String> toList(String[] value){
        return Arrays.asList(value);
    }
}
