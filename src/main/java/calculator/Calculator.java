package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("[\\d */+-]+");
    String input;
    private List<String> operator = new ArrayList<>();
    private List<Integer> operand = new ArrayList<>();

    private int result = 0;

    public Calculator(String expression) {
        if (isNullOfEmpty(expression)) {
            this.input = expression;
        }
        if (!EXPRESSION_PATTERN.matcher(expression).matches()) {
            throw new IllegalArgumentException("입력 값에 올바르지 않은 문자열이 포함되어 있습니다.");
        }
    }

    private boolean isNullOfEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null 이나 공백은 불가능합니다.");
        }
        return true;
    }

    public void split() {
        String[] strings = input.split(" ");
        for (String string : strings) {
            if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
                operator.add(string);
            } else {
                operand.add(Integer.valueOf(string));
            }
        }
    }

    public int calculate() {
        result = operand.get(0);
        for (int i = 0; i < operator.size(); i++) {
            if (operator.get(i).equals("+")) {
                result += operand.get(i + 1);
            } else if (operator.get(i).equals("-")) {
                result -= operand.get(i + 1);
            } else if (operator.get(i).equals("*")) {
                result *= operand.get(i + 1);
            } else if (operator.get(i).equals("/")) {
                result /= operand.get(i + 1);
            }
        }
        return result;
    }

    public List<String> getOperator() {
        return operator;
    }

    public List<Integer> getOperand() {
        return operand;
    }
}
