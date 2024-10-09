package calculator;

import calculator.domain.CalculateParameter;
import calculator.domain.OperatorMethod;
import calculator.enums.Operator;

public class StringCalculator {
    private static StringCalculator INSTANCE = null;

    private StringCalculator() {
    }

    public static StringCalculator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StringCalculator();
        }
        return INSTANCE;
    }

    public int calculate(Integer first, Integer second, String operator) {
        if (first == null || second == null || operator == null) {
            throw new IllegalStateException("null을 허용하지 않습니다.");
        }
        OperatorMethod operatorMethod = Operator.from(operator);
        return operatorMethod.operate(first, second);
    }

    public int calculate(String text) {
        CalculateParameter parameter = new CalculateParameter();
        parameter.makeParameter(text);
        parameter.validateQueueSize();
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
