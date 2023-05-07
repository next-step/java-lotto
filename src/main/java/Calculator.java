
public class Calculator {

    private static final String PLUS_OPERATOR = "+";
    private static final String MINUS_OPERATOR = "-";
    private static final String MULTIPLE_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";
    private static final String OPERATOR_MUST_BE_FOUR_ARITHMETIC_OPERATION = "연산자는 사칙연산만 가능합니다.";

    public int doCalculate(String lastNumberStr, String operator, String firstNumberStr) {
        int lastNumber = Integer.parseInt(lastNumberStr);
        int firstNumber = Integer.parseInt(firstNumberStr);
        if (operator.equals(PLUS_OPERATOR)) {
            return plus(lastNumber, firstNumber);
        }
        if (operator.equals(MINUS_OPERATOR)) {
            return minus(lastNumber, firstNumber);
        }
        if (operator.equals(DIVIDE_OPERATOR)) {
            return divide(lastNumber, firstNumber);
        }
        if (operator.equals(MULTIPLE_OPERATOR)) {
            return multiple(lastNumber, firstNumber);
        }
        throw new IllegalArgumentException(OPERATOR_MUST_BE_FOUR_ARITHMETIC_OPERATION);
    }

    private int plus(int lastNumber, int firstNumber) {
        return firstNumber + lastNumber;
    }

    private int minus(int lastNumber, int firstNumber) {
        return firstNumber - lastNumber;
    }

    private int divide(int lastNumber, int firstNumber) {
        return firstNumber / lastNumber;
    }

    private int multiple(int lastNumber, int firstNumber) {
        return firstNumber * lastNumber;
    }
}
