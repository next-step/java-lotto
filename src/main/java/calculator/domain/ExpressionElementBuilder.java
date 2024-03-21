package calculator.domain;

import calculator.exception.IllegalOperatorExpression;

import java.util.LinkedList;
import java.util.List;

public class ExpressionElementBuilder {

    private static final String NUMBER_REGEX = "\\d+";

    public static List<ExpressionElement> build(List<String> strings) {
        List<ExpressionElement> elements = new LinkedList<>();
        for (String string : strings) {
            elements.add(convert(string));
        }
        return elements;
    }

    private static ExpressionElement convert(String string) {
        if (isNumber(string)) {
            return new Number(Integer.parseInt(string));
        }
        if (OperatorType.isContains(string)) {
            return new Operator(string);
        }
        throw new IllegalOperatorExpression(IllegalOperatorExpression.formatMessage(string, OperatorType.getOperators()));
    }

    private static boolean isNumber(String element) {
        return element.matches(NUMBER_REGEX);
    }

}
