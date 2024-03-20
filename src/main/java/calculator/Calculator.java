package calculator;

import java.util.Stack;

public class Calculator {

    private final Stack<Integer> stack = new Stack<>();

    public Calculator() {
    }

    public int calculate(String text) {
        String operator = "";
        String[] splitText = text.split(" ");
        for (String str : splitText) {
            if (stack.empty()) {
                stack.push(Integer.parseInt(str));
            } else if (isOperator(str)) {
                operator = str;
            } else if (isNumber(str)) {
                stack.push(this.calculate(operator, stack.pop(), Integer.parseInt(str)));
            }
        }

        return stack.pop();
    }

    private boolean isNumber(String str) {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private int calculate(String operator, int a, int b) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
            return a * b;
        }

        return a / b;
    }

}
