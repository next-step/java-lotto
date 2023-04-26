package calculator.domain;

import calculator.Operator;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public Expression(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            separation(tokens, i);
        }
    }

    private void separation(String[] tokens, int index) {
        if (index % 2 == 0) {
            numbers.add(Integer.parseInt(tokens[index]));
            return;
        }

        operators.add(Operator.from(tokens[index]));
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operators.get(i).apply(result, numbers.get(i + 1));
        }
        return result;
    }

}
