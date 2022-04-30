package study.step1.domain;

import java.util.Stack;

public class StringCalculator {
    private final Stack<String> stack = new Stack<>();
    private final Formula formula;

    public StringCalculator(Formula formula) {
        this.formula = formula;
    }

    public static StringCalculator of(Formula formula) {
        return new StringCalculator(formula);
    }

    public void setUp() {
        String[] strArr = formula.getString().split(" ");
        int length = strArr.length-1;
        for (int i = length; i >= 0; i--) {
            stack.push(strArr[i]);
        }
    }

    public String start() {
        int num1 = 0;
        int num2 = 0;
        String operator = "";
        int length = stack.size()-3;

        for (int i = 0; i <= length; i++) {
            if (stack.size() == 1) break;
            num1 = Integer.parseInt(stack.pop());
            operator = stack.pop();
            num2 = Integer.parseInt(stack.pop());
            stack.push(calculate(num1, operator, num2));
        }

        return stack.pop();
    }

    private String calculate(int num1, String operator, int num2) {
        if ("+".equals(operator)) {
            return String.valueOf(num1 + num2);
        }
        if ("-".equals(operator)) {
            return String.valueOf(num1 - num2);
        }
        if ("*".equals(operator)) {
            return String.valueOf(num1 * num2);
        }
        if ("/".equals(operator)) {
            return String.valueOf(num1 / num2);
        }
        return "";
    }
}
