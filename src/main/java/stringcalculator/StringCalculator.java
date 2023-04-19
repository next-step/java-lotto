package stringcalculator;

public class StringCalculator {
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static int difference(int num1, int num2) {
        return num1 - num2;
    }

    public static int quotient(int num1, int num2) {
        if (num1 % num2 != 0) {
            throw new IllegalArgumentException("나눗셈의 결과가 정수로 떨어지지 않습니다.");
        }
        return num1 / num2;
    }

    public static int product(int num1, int num2) {
        return num1 * num2;
    }
}
