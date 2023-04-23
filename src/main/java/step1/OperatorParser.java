package step1;

import java.util.ArrayList;
import java.util.List;

public class OperatorParser {
    public List<Operator> parse(String input) {
        List<Operator> operators = new ArrayList<>();
        for (char c : input.toCharArray()) {
            addOperator(operators, String.valueOf(c));
        }
        validate(operators);
        return operators;
    }

    private void validate(List<Operator> operators) {
        if (operators.isEmpty()) {
            throw new IllegalArgumentException("연산자가 없습니다.");
        }
    }

    private void addOperator(List<Operator> operators, String symbol) {
        if (Operator.isOperator(symbol)) {
            operators.add(Operator.fromSymbol(symbol));
        }
    }
}
