package calculator;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private List<Integer> operands;
    private List<Operator> operators;

    public static Expression fromString(String stringExpression) {
        Expression expression = new Expression();
        expression.operands = new ArrayList<>();
        expression.operators = new ArrayList<>();
        var tokens = stringExpression.split(" ");
        for (var token : tokens) {
            expression.addToken(token);
        }
        return expression;
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    private void addToken(String token) {
        if (isNumeric(token)) {
            operands.add(Integer.parseInt(token));
            return;
        }
        operators.add(Operator.fromSign(token));
    }

    private Boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
