package step1.domain;

public class Calculator {
    public int add(int left, int right) {
        return left + right;
    }

    public int subtract(int left, int right) {
        return left - right;
    }

    public int multiply(int left, int right) {
        return left * right;
    }

    public int divide(int left, int right) {
        if (right == 0)
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return left / right;
    }
}
