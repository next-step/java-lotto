package calculator.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionParser {
    private static final String ONLY_NUMBERS_PATTERN = "^\\d+\\s\\d+\\s\\d+$";
    private static final Pattern INVALID_PATTERN = Pattern.compile(ONLY_NUMBERS_PATTERN);
    private static final String INTEGER_PATTERN = "^-?\\d+";
    private static final String OPERATOR_PATTERN = "(\\s*[+\\-*/]\\s*-?\\d+)*|$";

    private final String DELIMITER_PATTERN;
    private final String delimiter;
    private final Pattern pattern;

    public ExpressionParser(String delimiter) {
        this.delimiter = delimiter;
        this.DELIMITER_PATTERN = "(\\s*\\" + delimiter + "\\s*-?\\d+)*";

        this.pattern = createPatternUsingDelimiter();
    }

    private Pattern createPatternUsingDelimiter() {
        String regex = INTEGER_PATTERN + DELIMITER_PATTERN + OPERATOR_PATTERN;

        return Pattern.compile(regex);
    }

    public List<String> parse(String expression) {
        checkEmpty(expression);
        checkOnlyNumbersWithDelimiter(expression);
        checkExpression(expression);

        String[] parts = expression.split(delimiter);

        return Arrays.asList(parts);
    }

    private void checkEmpty(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("null 은 입력할 수 없습니다.");
        }
    }

    private void checkOnlyNumbersWithDelimiter(String expression) {
        if (INVALID_PATTERN.matcher(expression).matches()) {
            throw new IllegalArgumentException("연속된 숫자로만 이루어진 표현식은 유효하지 않습니다");
        }
    }

    private void checkExpression(String expression) {
        if (!pattern.matcher(expression).matches()) {
            throw new IllegalArgumentException("1개 이상의 정수가 포함되지 않았거나 정수,사칙연산자와 '" + delimiter + "' 외의 글자가 포함되어 있습니다.");
        }
    }
}
