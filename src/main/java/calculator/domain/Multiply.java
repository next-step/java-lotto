package calculator.domain;

public class Multiply implements Operator{
    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
