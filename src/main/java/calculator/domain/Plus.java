package calculator.domain;

public class Plus implements Operator {
    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
