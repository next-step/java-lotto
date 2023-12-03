package calculator.domain;

public class Minus implements Operator {
    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
