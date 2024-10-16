package service.arithmetic;

public class Divide implements Arithmetic {

    private static Divide instance;

    public static Divide getInstance() {
        if (instance == null) {
            instance = new Divide();
        }

        return instance;
    }

    private Divide() {}

    @Override
    public int calculate(int num1, int num2) {
        isInteger(num1, num2);

        return num1 / num2;
    }

    private void isInteger(int num1, int num2) {
        if (num1 % num2 != 0) {
            throw new ArithmeticException("두 수의 나눗셈 결과가 정수가 아닙니다.");
        }
    }
}
