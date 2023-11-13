package calculator.domain;

import calculator.domain.operator.Operator;
import calculator.domain.operator.OperatorFactory;

import java.util.List;

public class Calculator {
    List<String> inputString;

    public Calculator(List<String> inputString) {
        this.inputString = inputString;
    }

    public int calculate() {
        int result = Digit.of(inputString.get(0)).getNum();
        int point = 1;
        while (point < inputString.size()) {
            validateCalculate(point);
            result = partialCalculate(result, getNextOperator(point), getNextDigit(point));
            point += 2;
        }
        return result;
    }

    private Operator getNextOperator(int i) {
        return OperatorFactory.of(inputString.get(i));
    }

    private Digit getNextDigit(int i) {
        return Digit.of(inputString.get(i + 1));
    }

    private int partialCalculate(int num1, Operator operator, Digit num2) {
        return operator.operate(num1, num2.getNum());
    }

    private void validateCalculate(int i) {
        if ((i + 1) == inputString.size()) {
            throw new IllegalArgumentException("비정상적인 연산입니다.");
        }
    }
}
