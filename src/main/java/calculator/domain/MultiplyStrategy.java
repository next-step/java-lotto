package calculator.domain;

public class MultiplyStrategy implements OperationStrategy {
    @Override
    public int calculate(int number1, int number2) {
        return number1 * number2;
    }
}
