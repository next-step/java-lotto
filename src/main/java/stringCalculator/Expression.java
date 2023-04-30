package stringCalculator;

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
            Operator operator = Operator.of(operators.get(i));
            result = operator.calculate(result, Integer.parseInt(numbers.get(i + 1)));
        }
        return result;
    }


    private void seperateNumberAndOperater(String exp) {
        if (exp.matches(REGEXP)) {
            this.numbers.add(exp);
            return;
        }
        this.operators.add(exp);
    }
}
