package calculator;

import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final String CUSTOM_DELIMITER_EXP = "\\/\\/([^0-9]+)\\\\n";

    private MathExpression mathExpression;
    private String delimiter;

    public Expression(String expression) {
        parse(expression);
    }

    private void parse(String expression) {
        this.delimiter = getCustomDelimiterOrDefault(expression, DEFAULT_DELIMITER_REGEX);
        this.mathExpression = getMathExpression(expression);
    }

    public int execute(BinaryOperator<Integer> operator) {
        return mathExpression.execute(operator);
    }

    private MathExpression getMathExpression(String expression) {
        return new MathExpression(expression.replaceFirst(CUSTOM_DELIMITER_EXP, ""), this.delimiter);
    }

    private String getCustomDelimiterOrDefault(String expression, String defaultValue) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_EXP).matcher(expression);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return defaultValue;
    }
}
