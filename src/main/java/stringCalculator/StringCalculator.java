package stringCalculator;

import java.util.Stack;

public class StringCalculator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public static int calculate(String input) {
        putNullOrBlank(input);
        String[] strArr = getStringSplit(input);
        Stack stack = new Stack();
        for (int i = strArr.length-1; i >= 0; i--) {
            stack.add(strArr[i]);
        }

        for (int i = 0; i < strArr.length - 4; i++) {
            if (stack.size() == 1) {
                break;
            }
            int num1 = Integer.parseInt(stack.pop().toString());
            String operator = stack.pop().toString();
            int num2 = Integer.parseInt(stack.pop().toString());

            stack.push(classify(num1, operator, num2));
        }
        return Integer.parseInt(stack.pop().toString());
    }

    private static String[] getStringSplit(String input) {
        String[] strArr = input.split(" ");
        return strArr;
    }

    public static String classify(int num1, String operator, int num2) {
        switch (operator) {
            case PLUS:
                return String.valueOf(num1 + num2);
            case MINUS:
                return String.valueOf(num1 - num2);
            case MULTIPLY:
                return String.valueOf(num1 * num2);
            case DIVIDE:
                return String.valueOf(num1 / num2);

                default: throw new IllegalArgumentException("사칙연산 기호만 입력받을 수 있습니다.");
        }
    }

    public static void putNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열과 null값은 입력받을 수 없습니다.");
        }
    }

}
