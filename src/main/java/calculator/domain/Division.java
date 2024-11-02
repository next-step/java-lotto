package calculator.domain;

public class Division implements Operation {
    @Override
    public int calculate(int a, int b) {
        validateDivision(a, b);
        return a / b;
    }

    private static void validateDivision(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }

        if (a % b > 0) {
            throw new IllegalArgumentException("결과 값이 정수 여야 합니다.");
        }
    }
}
