import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValue {
    private static final Pattern FILTER = Pattern.compile("^([0-9-+*/\\s]+)$");
    private static final String BLANK = "\\s";
    private final List<String> expression;

    public InputValue(String input) {
        validateInput(input);
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

    private void validateInput(String input) {
        validateSplit(input);
        validateBlank(input);
        validateEmpty(input);
    }

    private void validateSplit(String input) {
        if (!FILTER.matcher(input).matches()) {
            throw new WrongInputException("사칙연산 기호, 숫자, 앞의 둘을 포함한 공백외에는 입력 받을 수 없습니다.");
        }
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new WrongInputException("값이 없는 빈 공백은 입력 받을 수 없습니다.");
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new WrongInputException("빈 값은 입력 받을  수 없습니다.");
        }
    }

    public boolean hasSize(int expect) {
        return expression.size() == expect;
    }
}
