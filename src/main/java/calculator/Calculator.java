package calculator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Calculator {

    public static final String ERR_INPUT_ARG = "Null이나 빈 공백은 입력할 수 없습니다.";

    private Queue<Integer> numbers = new LinkedList<>();
    private Queue<String> ops = new LinkedList<>();
    private Operator operator;

    private void inputExpression(String s) {
        if (isNullOrBlank(s)) {
            throw new IllegalArgumentException(ERR_INPUT_ARG);
        }
        String[] expression = s.split(" ");
        for (String e : expression) {
            putExpressions(e);
        }
    }
    public int calculate(String s) {
        inputExpression(s);

        int result = numbers.poll();
        while (!numbers.isEmpty()) {
            int a = numbers.poll();
            String op = ops.poll();
            result = Operator.findOperator(op).operate(result, a);
        }
        return result;
    }

    private boolean isNullOrBlank(String s) {
        return Objects.isNull(s) || s.replaceAll(" ", "").equals("");
    }

    private void putExpressions(String e) {
        if (Character.isDigit(e.charAt(0))) {
            numbers.offer(Integer.parseInt(e));
        }
        if (!Character.isDigit(e.charAt(0))) {
            ops.offer(e);
        }
    }
}
