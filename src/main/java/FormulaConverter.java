import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FormulaConverter {
    private static final char DIVE = '/';
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';


    public static Queue<String> convert(String input) {
        checkNotEmpty(input);

        Queue<String> formulaQueue = new LinkedList<>();
        Stack<String> validateStack = new Stack<>();

        String[] splits = input.split(" ");
        for (String split : splits) {
            validate(split);
            formulaQueue.add(split);
            validateStack.add(split);
        }

        validateFormula(validateStack);

        return formulaQueue;
    }

    private static void validate(String split) {
        if (isNumber(split)) {
            return;
        }

        for (int i = 0; i < split.length(); i++) {
            checkCharacter(split.charAt(i));
        }
    }

    private static void validateFormula(Stack<String> validateStack) {

        String beforeToken = validateStack.pop();
        while (!validateStack.isEmpty()) {
            String token = validateStack.pop();
            validateToken(beforeToken, token);
            beforeToken = token;
        }

        if (!isNumber(beforeToken)) {
            throwFormatError();
        }
    }

    private static void validateToken(String beforeToken, String token) {
        if (isNumber(beforeToken) && isNumber(token)) {
            throwFormatError();
        }

        if (!isNumber(beforeToken) && !isNumber(token)) {
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

    private static void checkNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private static void checkCharacter(char c) {
        if (!isOperator(c)) {
            throw new IllegalArgumentException("연산자가 아닙니다.");
        }
    }

    private static boolean isOperator(char c) {
        return c == MINUS || c == PLUS || c == MULTIPLY || c == DIVE;
    }
}
