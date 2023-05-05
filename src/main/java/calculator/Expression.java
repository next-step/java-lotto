package calculator;

import java.util.List;

public class Expression {
    private List<Operator> operators;
    private List<Number> numbers;

    public Expression(List<Number> numbers, List<Operator> operators) {
        validCheck(numbers, operators);
        this.numbers = numbers;
        this.operators = operators;
    }

    private void validCheck(List<Number> numbers, List<Operator> operators) {
        if ((numbers.size() - operators.size()) != 1) {
            throw new IllegalArgumentException("숫자의 총 합이 연산자의 총 합보다 하나 더 커야 합니다.");
        }
    }

    public Number calculate() {
        Number firstNumber = this.numbers.get(0);
        for (int i = 1; i < this.numbers.size() + this.operators.size(); i += 2) {
            Operator operator = operators.get(i / 2);
            Number secondNumber = numbers.get((i + 1) / 2);
            Number nextNumber = operator.calculateTwoNumber(firstNumber, secondNumber);
            firstNumber = new Number(nextNumber.getNumber());
        }

        return firstNumber;
    }

}
