package calculator;

import calculator.domain.CalculateParameter;
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

    public int calculate(Integer num1, Integer num2, Operator operator) {
        if (num1 == null || num2 == null || operator == null) {
            throw new IllegalStateException("null을 허용하지 않습니다.");
        }
        return operator.operate(num1, num2);
    }

    public int calculate(String text) {
        CalculateParameter parameter = new CalculateParameter();
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
