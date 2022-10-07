import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValue {
    private static final Pattern FILTER = Pattern.compile("^([0-9-+*/\\s]+)$");
    private static final String BLINK = "\\s";
    private final List<String> expression;

    public InputValue(String input) {
        validateInput(input);
        this.expression = changeList(input);
    }

    private List<String> changeList(String input) {
        return Arrays.stream(splitInput1(input)).collect(Collectors.toList());
    }

    private String[] splitInput1(String input) {
        return input.split(BLINK);
    }

    public List<String> getExpression() {
        return Collections.unmodifiableList(expression);
    }

    private void validateInput(String input) {
        if (!FILTER.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasSize(int expect) {
        return expression.size() == expect;
    }
}
