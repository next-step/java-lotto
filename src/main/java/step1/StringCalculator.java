package step1;

import java.util.Objects;

public class StringCalculator {

    private final Operators operators;
    private final Numbers numbers;

    public StringCalculator() {
        operators = new Operators();
        numbers = new Numbers();
    }

    public StringCalculator(Operators operators, Numbers numbers) {
        this.operators = operators;
        this.numbers = numbers;
    }

    public void addElement(String element) {
        try {
            numbers.addNumber(element);
        } catch (NumberFormatException e) {
            operators.addOperator(element);
        }
    }

    public int calculate() {
        if (!hasOperatorsAndNumbers())
            throw new RuntimeException("초기 연산자와 숫자 세팅이 이루어지지 않았습니다.");

        return calculateWithOperatorsAndNumbers();
    }

    private boolean hasOperatorsAndNumbers() {
        return operators.hasElement() && numbers.hasNumber();
    }

    private int calculateWithOperatorsAndNumbers() {
        int result = numbers.getNumber(0);

        for (int i = 1; i < numbers.size(); i++) {
            result = operators.calculate(result, numbers.getNumber(i), i-1);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringCalculator that = (StringCalculator) o;
        return Objects.equals(operators, that.operators) && Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operators, numbers);
    }

}
