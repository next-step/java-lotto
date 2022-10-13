package step1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private Calculator() {
    }

    public static void calculate(String input) {
        String[] arguments = split(input);
        Deque<Integer> operands = collectOperands(arguments);
        Deque<Operator> operators = collectOperators(arguments);
    }

    public static Deque<Integer> collectOperands(String[] arguments) {
        Deque<Integer> operands = new ArrayDeque<>();

        for (int i = 0; i < arguments.length; i += 2) {
            operands.add(toInt(arguments[i]));
        }

        return operands;
    }

    public static Deque<Operator> collectOperators(String[] arguments) {
        Deque<Operator> operators = new ArrayDeque<>();

        for (int i = 1; i < arguments.length; i += 2) {
            operators.add(Operator.of(arguments[i]));
        }

        return operators;
    }

    public static String[] split(String input) {
        return input.split(" ");
    }

    public static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("피연산자 변환 과정에서 오류가 발생했습니다. 정수를 입력해주세요.");
        }
    }
}
