import java.util.Stack;

public class StringCalculator {

    public static int calculate(String givenValue) {
        Stack<String> stack = new Stack<>();
        String[] strings = givenValue.split(" ");
        for (String string : strings) {
            if (string == null) {
                throw new IllegalArgumentException("입력값은 null 일 수 없습니다.");
            }
            if (string.isBlank()) {
                throw new IllegalArgumentException("입력값은 공백 일 수 없습니다.");
            }

            stack.add(string);
            if (stack.size() == 3) {
                calculate(stack);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static void calculate(Stack<String> stack) {
        int lastNumber = Integer.parseInt(stack.pop());
        String operator = stack.pop();
        int firstNumber = Integer.parseInt(stack.pop());
        if (isNotFourArithmeticOperations(operator)) {
            throw new IllegalArgumentException("연산자는 사칙연산만 가능합니다.");
        }
        if (operator.equals("+")) {
            stack.add(String.valueOf(firstNumber + lastNumber));
        }
        if (operator.equals("-")) {
            stack.add(String.valueOf(firstNumber - lastNumber));
        }
        if (operator.equals("/")) {
            stack.add(String.valueOf(firstNumber / lastNumber));
        }
        if (operator.equals("*")) {
            stack.add(String.valueOf(firstNumber * lastNumber));
        }
    }

    private static boolean isNotFourArithmeticOperations(String operator) {
        return !operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/");
    }

    public static void main(String[] args) {
        int value = calculate("2 + 3 * 4 / 2");
        System.out.println("value = " + value);
    }
}
