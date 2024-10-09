package calculator;

import calculator.domain.CalculateParameter;

import static calculator.enums.Operator.*;

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
        if (PLUS.getOperator().equals(operator)) {
            return first + second;
        }
        if (MINUS.getOperator().equals(operator)) {
            return first - second;
        }
        if (MULTIPLY.getOperator().equals(operator)) {
            return first * second;
        }
        if (DIVIDE.getOperator().equals(operator)) {
            return first / second;
        }
        throw new IllegalStateException("연산자가 아닌 문자는 허용하지 않습니다.");
    }

    public int calculate(String text) {
        CalculateParameter parameter = new CalculateParameter();
        parameter.makeParameter(text);
        parameter.validQueueSize();
        return getResult(parameter);
    }

    private int getResult(CalculateParameter parameter) {
        int result = firstCalculate(parameter);
        while (!parameter.isEmpty()) {
            result = calculate(result, parameter.getNumber(), parameter.getOperator());
        }
        return result;
    }



    private int firstCalculate(CalculateParameter parameter) {
        return calculate(parameter.getNumber(), parameter.getNumber(), parameter.getOperator());
    }

}
