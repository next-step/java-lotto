package step1;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final String REGEXP = "^[0-9]+$";
    private List<String> operators;
    private List<String> numbers;

    public Expression(String[] expression) {
        if (expression.length < 3) {
            throw new IllegalArgumentException("형식에 맞춰 식을 입력하세요");
        }
        operators = new ArrayList<>();
        numbers = new ArrayList<>();
        for (String exp : expression) {
            seperateNumberAndOperater(exp);
        }
    }

    public int calculate() {
        int result = Integer.parseInt(numbers.get(0));
        for (int i = 0; i < operators.size(); i++) {
            String operator = operators.get(i);
            int number = Integer.parseInt(numbers.get(i + 1));
            result = operate(result, operator, number);
        }
        return result;
    }

    public int operate(int result, String operator, int number) {
        result = plus(result, operator, number);
        result = minus(result, operator, number);
        result = multiply(result, operator, number);
        result = divide(result, operator, number);
        return result;
    }

    public Integer divide(int result, String operator, int number) {
        if ("/".equals(operator)) {
            return result / number;
        }
        return result;
    }

    public Integer multiply(int result, String operator, int number) {
        if ("*".equals(operator)) {
            return result * number;
        }
        return result;
    }

    public Integer minus(int result, String operator, int number) {
        if ("-".equals(operator)) {
            return result - number;
        }
        return result;
    }

    public Integer plus(int result, String operator, int number) {
        if ("+".equals(operator)) {
            return result + number;
        }
        return result;
    }

    public void seperateNumberAndOperater(String exp) {
        if (exp.matches(REGEXP)) {
            this.numbers.add(exp);
            return;
        }

        this.operators.add(exp);

    }
}
