import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FormulaConverter {

    public static Queue<String> convert(String input) {
        checkEmpty(input);

        Queue<String> queue = new LinkedList<>();
        Stack<String> validateStack = new Stack<>();

        String[] splits = input.split(" ");
        for (String split : splits) {
            validate(split);
            validateFormula(validateStack, split);

            queue.add(split);
            validateStack.add(split);
        }
        return queue;
    }

    private static void validate(String split) {
        if(isNumber(split)) {
            return;
        }

        for(int i = 0; i < split.length(); i++) {
            checkAlphabetic(split.charAt(i));
            checkCharacter(split.charAt(i));
        }
    }

    private static void validateFormula(Stack<String> stack, String op) {
        if(stack.isEmpty() && !isNumber(op)) {
            throwFormatError();
        }

        if(!stack.isEmpty() && isNumber(stack.peek()) && isNumber(op)) {
            throwFormatError();
        }

        if(!stack.isEmpty() && !isNumber(stack.peek()) && !isNumber(op)) {
            throwFormatError();
        }
    }

    private static void throwFormatError() {
        throw new IllegalArgumentException("수식이 알맞지 않습니다.");
    }

    private static boolean isNumber(String op) {
        try {
            Integer.valueOf(op);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static void checkEmpty(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private static void checkCharacter(char c) {
        if(!isOperator(c)) {
            throw new IllegalArgumentException("연산자가 아닙니다.");
        }
    }

    private static void checkAlphabetic(char c) {
        if(Character.isAlphabetic(c)) {
            throw new IllegalArgumentException("영어는 들어올 수 없습니다.");
        }
    }

    private static boolean isOperator(char c) {
        return c == '-' || c == '+' || c == '*' || c == '/';
    }
}
