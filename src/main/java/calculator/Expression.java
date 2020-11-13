package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expression {

    static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final String CUSTOM_DELIMITER_EXP = "\\/\\/([^0-9]+)\\\\n";

    private String mathExpression;
    private String delimiter;

    private List<Integer> operands;

    public Expression(String expression) {
        parse(expression);
    }

    private void parse(String expression) {
        this.delimiter = getCustomDelimiterOrDefault(expression, DEFAULT_DELIMITER_REGEX);
        this.mathExpression = getMathExpression(expression);
        this.operands = getOperands();
    }

    private List<Integer> getOperands() {
        List<Integer> operands = Arrays.stream(this.mathExpression.split(delimiter))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        if (operands.stream().anyMatch(this::lessThanZero))
            throw new RuntimeException("0 또는 양수만 입력 가능합니다.");
        return operands;
    }

    private boolean lessThanZero(Integer value) {
        return value < 0;
    }

    public int execute(BinaryOperator<Integer> operator) {
        return operands.stream().reduce(0, operator);
    }

    private String getMathExpression(String expression) {
        return expression.replaceFirst(CUSTOM_DELIMITER_EXP, "");
    }

    private String getCustomDelimiterOrDefault(String expression, String defaultValue) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_EXP).matcher(expression);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return defaultValue;
    }
}
