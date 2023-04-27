import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionParser {
    private static final String INTEGER_PATTERN = "^-?[\\d]+([\\s]*[";
    private static final String OPERATOR_PATTERN = "][\\s]*[\\d]+)*$";
    private final String delimiter;

    private final Pattern pattern;

    public ExpressionParser(String delimiter) {
        this.delimiter = delimiter;
        this.pattern = createPatternUsingDelimiter();
    }

    private Pattern createPatternUsingDelimiter() {
        String regex = INTEGER_PATTERN + Pattern.quote(delimiter) + OPERATOR_PATTERN;

        return Pattern.compile(regex);
    }

    public List<String> parse(String expression) {
        checkNull(expression);
        checkExpression(expression);

        String[] parts = expression.split(delimiter);

        return Arrays.asList(parts);
    }

    private void checkNull(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("null 은 입력할 수 없습니다.");
        }
    }

    private void checkExpression(String expression) {
        if (!pattern.matcher(expression).matches()) {
            throw new IllegalArgumentException("1개 이상의 정수가 포함되지 않았거나 정수,사칙연산자와 '" + delimiter + "' 외의 글자가 포함되어 있습니다.");
        }
    }
}
