package stringcalculate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValue {
    private static final String BLANK = "\\s";
    private final List<String> expression;

    public InputValue(String input) {
        InputVerifier.validateInput(input);
        this.expression = changeList(input);
    }

    private List<String> changeList(String input) {
        return Arrays
                .stream(splitInput(input))
                .collect(Collectors.toList());
    }

    private String[] splitInput(String input) {
        return input.split(BLANK);
    }

    public int getSize() {
        return expression.size();
    }

    public List<String> getExpression() {
        return Collections.unmodifiableList(expression);
    }


    public boolean hasSize(int expect) {
        return expression.size() == expect;
    }
}
