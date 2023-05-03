import java.util.Stack;

public class StringCalculator {
    private static final String BLANK = " ";
    public static final String GIVEN_STRING_MUST_NOT_BE_NULL = "입력값은 null 일 수 없습니다.";
    public static final String GIVEN_STRING_MUST_NOT_BE_BLANK = "입력값은 공백 일 수 없습니다.";
    public static final String PLUS_OPERATOR = "+";
    public static final String MINUS_OPERATOR = "-";
    public static final String MULTIPLE_OPERATOR = "*";
    public static final String DIVIDE_OPERATOR = "/";
    public static final String OPERATOR_MUST_BE_FOUR_ARITHMETIC_OPERATION = "연산자는 사칙연산만 가능합니다.";

    public static int calculateByGivenString(String givenValue) {
        checkIsNullOrBlank(givenValue);
        Stack<String> stack = new Stack<>();
        String[] strings = givenValue.split(BLANK);
        for (String string : strings) {
            stack.add(string);
            calculateIsAbleToCalculate(stack);
        }
        return Integer.parseInt(stack.pop());
    }

    private static void checkIsNullOrBlank(String givenValue) {
        if (givenValue == null) {
            throw new IllegalArgumentException(GIVEN_STRING_MUST_NOT_BE_NULL);
        }
        if (givenValue.isBlank()) {
            throw new IllegalArgumentException(GIVEN_STRING_MUST_NOT_BE_BLANK);
        }
    }

    private static void calculateIsAbleToCalculate(Stack<String> stack) {
        if (stack.size() == 3) {
            doCalculate(stack);
        }
    }

    private static void doCalculate(Stack<String> stack) {
        int lastNumber = Integer.parseInt(stack.pop());
        String operator = stack.pop();
        checkIsNotFourArithmeticOperations(operator);
        int firstNumber = Integer.parseInt(stack.pop());

        if (operator.equals(PLUS_OPERATOR)) {
            stack.add(String.valueOf(plus(lastNumber, firstNumber)));
        }
        if (operator.equals(MINUS_OPERATOR)) {
            stack.add(String.valueOf(minus(lastNumber, firstNumber)));
        }
        if (operator.equals(DIVIDE_OPERATOR)) {
            stack.add(String.valueOf(divide(lastNumber, firstNumber)));
        }
        if (operator.equals(MULTIPLE_OPERATOR)) {
            stack.add(String.valueOf(multiple(lastNumber, firstNumber)));
        }
    }

    private static void checkIsNotFourArithmeticOperations(String operator) {
        if (!operator.equals(PLUS_OPERATOR) && !operator.equals(MINUS_OPERATOR)
                && !operator.equals(MULTIPLE_OPERATOR) && !operator.equals(DIVIDE_OPERATOR)) {
            throw new IllegalArgumentException(OPERATOR_MUST_BE_FOUR_ARITHMETIC_OPERATION);
        }
    }


    private static int plus(int lastNumber, int firstNumber) {
        return firstNumber + lastNumber;
    }

    private static int minus(int lastNumber, int firstNumber) {
        return firstNumber - lastNumber;
    }

    private static int divide(int lastNumber, int firstNumber) {
        return firstNumber / lastNumber;
    }

    private static int multiple(int lastNumber, int firstNumber) {
        return firstNumber * lastNumber;
    }
}
