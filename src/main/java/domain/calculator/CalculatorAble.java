package domain.calculator;

public interface CalculatorAble {
    default int sum(int a, int b) {
        return a + b;
    }

    default int subtract(int a, int b) {
        return a - b;
    }

    default int multiply(int a, int b) {
        return a * b;
    }

    default int divide(int a, int b) {
        return a / b;
    }
}
