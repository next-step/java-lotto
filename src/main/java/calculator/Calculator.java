package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    public static final String ERR_INPUT_ARG = "Null이나 빈 공백은 입력할 수 없습니다.";
    private Queue<Integer> numbers = new LinkedList<>();
    private Queue<String> ops = new LinkedList<>();

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int calculate(String s) {
        if (isNullOrBlank(s)) {
            throw new IllegalArgumentException(ERR_INPUT_ARG);
        }
        String[] expression = s.split(" ");

        for (String e : expression) {
            putExpressions(e);
        }

        int result = numbers.poll();
        while (!numbers.isEmpty()) {
            int a = numbers.poll();
            String op = ops.poll();
            result = operation(result, a, op);
        }

        return result;
    }

    private boolean isNullOrBlank(String s) {
        return s == null || s.equals("");
    }

    private void putExpressions(String e) {
        if (Character.isDigit(e.charAt(0))) {
            numbers.offer(Integer.parseInt(e));
        }
        if (!Character.isDigit(e.charAt(0))) {
            ops.offer(e);
        }
    }

    private int operation(int a, int b, String op) {
        if (op.equals("+")) {
            return plus(a, b);
        }
        if (op.equals("-")) {
            return minus(a, b);
        }
        if (op.equals("*")) {
            return multiply(a, b);
        }
        if (op.equals("/")) {
            return divide(a, b);
        }
        return 0;
    }
}
