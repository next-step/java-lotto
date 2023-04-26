package calculator;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    public List<Integer> operands;
    public List<Operator> operators;

    public Expression(String stringExpression) {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        var tokens = stringExpression.split(" ");
        for (var token : tokens) {
            addToken(token);
        }
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
