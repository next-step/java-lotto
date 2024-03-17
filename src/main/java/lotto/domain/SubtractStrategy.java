package lotto.domain;

public class SubtractStrategy implements OperationStrategy {
    @Override
    public int calculate(int number1, int number2) {
        return number1 - number2;
    }
}
