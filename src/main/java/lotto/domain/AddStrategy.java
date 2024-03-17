package lotto.domain;

public class AddStrategy implements OperationStrategy {
    @Override
    public int calculate(int number1, int number2) {
        return number1 + number2;
    }
}
