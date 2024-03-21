package calculator;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private Integer result;
    private String operator;

    public int calculate(String text) {
        List<String> elements = StringClassifier.split(text);

        for (String element : elements) {
            process(element);
        }

        return result;
    }

    private void process(String element) {
        if (result == null) {
            result = Integer.parseInt(element);
        } else if (StringClassifier.isOperator(element)) {
            operator = element;
        } else if (StringClassifier.isNumber(element)) {
            Operator foundOperator = Operator.getOperator(operator);
            result = foundOperator.calculate(result, Integer.parseInt(element));
        }
    }
}
