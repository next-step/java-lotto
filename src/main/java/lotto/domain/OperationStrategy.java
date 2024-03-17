package lotto.domain;

@FunctionalInterface
public interface OperationStrategy {

    int calculate(int number1, int number2);

}
