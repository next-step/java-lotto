package calculator;

import calculator.enums.Operator;

public class StringCalculator {
    private final CalculateParameter parameter;

    public StringCalculator(CalculateParameter parameter) {
        this.parameter = parameter;
    }

    int calculate(Integer num1, Integer num2, Operator operator) {
        return operator.operate(num1, num2);
    }

    public int calculate(String text) {
        parameter.makeParameter(text);
        return getResult(parameter);
    }

    private int getResult(CalculateParameter parameter) {
        int result = parameter.getNumber();
        while (!parameter.isEmpty()) {
            result = calculate(result, parameter.getNumber(), parameter.getOperator());
        }
        return result;
    }

}
