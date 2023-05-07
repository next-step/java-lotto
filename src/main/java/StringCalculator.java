import java.util.Stack;

public class StringCalculator {
    private static final String BLANK = " ";
    public static final String GIVEN_STRING_MUST_NOT_BE_NULL = "입력값은 null 일 수 없습니다.";
    public static final String GIVEN_STRING_MUST_NOT_BE_BLANK = "입력값은 공백 일 수 없습니다.";

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
            Calculator calculator = new Calculator();
            stack.add(String.valueOf(calculator.doCalculate(stack.pop(), stack.pop(), stack.pop())));
        }
    }

}
