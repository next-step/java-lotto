package calculator;

public class Operator {
    public static int operate(int firstOperand, String operator, int secondOperand) {
        if (operator.equals("+")) return plus(firstOperand, secondOperand);
        if (operator.equals("-")) return minus(firstOperand, secondOperand);
        if (operator.equals("*")) return multiply(firstOperand, secondOperand);
        if (operator.equals("/")) return divide(firstOperand, secondOperand);

        throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
    }

    private static int plus(int firstAddend, int secondAddend) {
        return firstAddend + secondAddend;
    }

    private static int minus(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    private static int multiply(int firstMultiplier, int secondMultiplier) {
        return firstMultiplier * secondMultiplier;
    }

    private static int divide(int dividend, int divisor) {
        return dividend / divisor;
    }
}
