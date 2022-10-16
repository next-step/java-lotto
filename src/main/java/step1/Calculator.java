package step1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private static final int OPERAND_START_INDEX = 0;
    private static final int OPERATOR_START_INDEX = 1;
    private static final int STEP = 2;
    private static final String BLANK = " ";

    private Calculator() {
    }

    public static void calculate(String input) {
        String[] arguments = split(input);
        validateExpression(arguments);
        
        Deque<Integer> operands = collectOperands(arguments);
        Deque<Operator> operators = collectOperators(arguments);
    }

    public static Deque<Integer> collectOperands(String[] arguments) {
        Deque<Integer> operands = new ArrayDeque<>();

        for (int i = OPERAND_START_INDEX; i < arguments.length; i += STEP) {
            operands.add(toInt(arguments[i]));
        }

        return operands;
    }

    public static Deque<Operator> collectOperators(String[] arguments) {
        Deque<Operator> operators = new ArrayDeque<>();

        for (int i = OPERATOR_START_INDEX; i < arguments.length; i += STEP) {
            operators.add(Operator.of(arguments[i]));
        }

        return operators;
    }

    public static String[] split(String input) {
        return input.split(BLANK);
    }

    public static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("피연산자 변환 과정에서 오류가 발생했습니다. 정수를 입력해주세요.");
        }
    }

    private static void validateExpression(String[] arguments) {
        if (hasEvenCount(arguments)) {
            throw new IllegalArgumentException("올바르지 않은 계산식입니다.");
        }
    }

    private static boolean hasEvenCount(String[] arguments) {
        return arguments.length % 2 == 0;
    }
}
