package calculator.domain;

import calculator.domain.operator.Operator;
import calculator.domain.operator.OperatorFactory;

import java.util.List;

public class Calculator {
    private final int START_POINT = 1;
    private final List<String> elements;
    private int point;


    public Calculator(List<String> elements) {
        this.elements = elements;
    }

    public int calculate() {
        int result = Digit.of(elements.get(point)).getNum();
        point = START_POINT;
        while (point < elements.size()) {
            validateCalculate();
            result = partialCalculate(result, getNextOperator(), getNextDigit());
            moveNextPoint();
        }
        return result;
    }

    private int partialCalculate(int num1, Operator operator, Digit num2) {
        return operator.operate(num1, num2.getNum());
    }

    private Operator getNextOperator() {
        return OperatorFactory.of(elements.get(point));
    }

    private Digit getNextDigit() {
        return Digit.of(elements.get(point + 1));
    }

    private void moveNextPoint() {
        point += 2;
    }

    private void validateCalculate() {
        if ((point + 1) == elements.size()) {
            throw new IllegalArgumentException("비정상적인 연산입니다.");
        }
    }
}
