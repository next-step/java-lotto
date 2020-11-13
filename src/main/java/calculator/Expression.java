package calculator;

import sun.tools.jstat.Operator;

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
        this.delimiter = getCustomDelimiterOrDefault(expression, DEFAULT_DELIMITER_REGEX);
        this.mathExpression = getMathExpression(expression);
        this.operands = Arrays.stream(this.mathExpression.split(delimiter)).map(Integer::valueOf).collect(Collectors.toList());
    }

    public int execute(BinaryOperator<Integer> operator){
        return operands.stream().reduce(0, operator);
    }

    private String getMathExpression(String expression) {
        return expression.replaceFirst(CUSTOM_DELIMITER_EXP, "");
    }

    private String getCustomDelimiterOrDefault(String expression, String defaultValue) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_EXP).matcher(expression);
        if( matcher.find() ){
            return matcher.group(1);
        }
        return defaultValue;
    }
}
