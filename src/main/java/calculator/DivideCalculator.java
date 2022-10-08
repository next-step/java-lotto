package calculator;

public class DivideCalculator implements Calculator {
    @Override
    public int calculate(int a, int b) {
        if (a % b != 0) {
            throw new IllegalArgumentException("나눗셈의 결과가 정수가 아닙니다.");
        }
        return a / b;
    }
}
