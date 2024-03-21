package calculator;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private Integer result;
    private String operator;
    public Calculator() {
    }

    public int calculate(String text) {
        List<String> splitText = StringClassifier.split(text);

        for (String s : splitText) {
            if (result == null) {
                result = Integer.parseInt(s);
            } else if (StringClassifier.isOperator(s)) {
                operator = s;
            } else if (StringClassifier.isNumber(s)) {
                Operator foundOperator = Operator.getOperator(operator);
                result = foundOperator.calculate(result, Integer.parseInt(s));
            }
        }

        return result;
    }

}
