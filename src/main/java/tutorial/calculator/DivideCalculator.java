package tutorial.calculator;

public class DivideCalculator implements AbstractCalculator {
    @Override
    public int calculate(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
