package domain;

public class Calculator {

    public int add(int num1, int num2) {
        return num1 + num2;

    }

    public int substract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0 으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }
}
