package step1;

import java.util.ArrayList;
import java.util.List;

public class OperatorParser {
    public Operators parse(Expression expression) {
        List<Operator> operators = new ArrayList<>();
        for (char c : expression.getCharArray()) {
            addOperator(operators, c);
        }
        return Operators.of(operators);
    }

    private void addOperator(List<Operator> operators, char symbol) {
        if (Operator.isOperator(symbol)) {
            operators.add(Operator.fromSymbol(symbol));
        }
    }
}
