package calculator;

public class Operator {
    private final static char ADD_CHAR = '+';
    private final static char SUBTRACT_CHAR = '-';
    private final static char MULTIPLY_CHAR = '*';
    private final static char DIVIDE_CHAR = '/';

    public static Integer operate(int num1, String operator, int num2) {
        if (operator.charAt(0) == ADD_CHAR) {
            return add(num1, num2);
        }
        if (operator.charAt(0) == SUBTRACT_CHAR) {
            return subtract(num1, num2);
        }
        if (operator.charAt(0) == MULTIPLY_CHAR) {
            return multiply(num1, num2);
        }
        if (operator.charAt(0) == DIVIDE_CHAR) {
            return divide(num1, num2);
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }

    private static int add(int num1, int num2) {
        return num1 + num2;
    }

    private static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private static int divide(int num1, int num2) {
        return num1 / num2;
    }

}
