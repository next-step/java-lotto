package calculator.domain;

public class DivideStrategy implements OperationStrategy {
    @Override
    public int calculate(int number1, int number2) {
        try {
            return number1 / number2;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("0 으로 나눌 수 없습니다.");
        }
    }
}
