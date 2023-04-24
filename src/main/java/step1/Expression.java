package step1;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final String REGEXP = "^[0-9]+$";
    private List<String> operators;
    private List<String> numbers;

    public Expression(String[] expression) {
        operators = new ArrayList<>();
        numbers = new ArrayList<>();
        for (String exp : expression) {
            seperateNumberAndOperater(exp);
        }
    }

    public int calculate() {
        int result = Integer.parseInt(numbers.get(0));
        for (int i = 0; i < operators.size(); i++) {
            result = operate(result, i);
        }
        return result;
    }

    public int operate(int result, int i) {
        String operator = operators.get(i);
        int number = Integer.parseInt(numbers.get(i + 1));
        if ("+".equals(operator)) {
            return result + number;
        }
        if ("-".equals(operator)) {
            return result - number;
        }
        if ("*".equals(operator)) {
            return result * number;
        }
        if ("/".equals(operator)) {
            return result / number;
        }
        return result;
    }

    private void seperateNumberAndOperater(String exp) {
        if (exp.matches(REGEXP)) {
            this.numbers.add(exp);
            return;
        }
        if (!exp.matches(REGEXP)) {
            this.operators.add(exp);
        }
    }
}
