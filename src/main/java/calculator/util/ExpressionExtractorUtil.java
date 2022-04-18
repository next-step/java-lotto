package calculator.util;

import calculator.model.Number;
import calculator.model.Operator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class ExpressionExtractorUtil {

    private static final String OPERATOR_REGULAR_EXPRESSION = "[+\\-*/]";

    private static final String NUMBER_REGULAR_EXPRESSION = "[0-9]";

    private static final String BLANK = "";

    private ExpressionExtractorUtil() {
    }

    public static List<Number> extractNumbers(String expression) {
        String[] splitNumbers = expression.split(OPERATOR_REGULAR_EXPRESSION);
        return Arrays.stream(splitNumbers)
                .map(number -> new Number(Integer.parseInt(number)))
                .collect(toList());
    }

    public static List<Operator> extractOperators(String expression) {
        String operators = String.copyValueOf(expression.toCharArray()).replaceAll(NUMBER_REGULAR_EXPRESSION, BLANK);
        String[] splitOperators = operators.split("");
        return Arrays.stream(splitOperators)
                .map(Operator::from)
                .collect(toList());
    }

}
