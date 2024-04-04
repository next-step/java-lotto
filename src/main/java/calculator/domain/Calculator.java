package calculator.domain;

import util.StringValidator;

public class Calculator {
    private Integer result;
    private String operator;

    public Integer getCalculatedRes() {
        return this.result;
    }

    public int calculate(String[] elements) {
        for (String element : elements) {
            process(element);
        }
        return result;
    }

    private void process(String element) {
        if (result == null) {
            result = Integer.parseInt(element);
        } else if (StringValidator.isOperator(element)) {
            operator = element;
        } else if (StringValidator.isNumber(element)) {
            Operator foundOperator = Operator.getOperator(operator);
            result = foundOperator.calculate(result, Integer.parseInt(element));
        }
    }
}
