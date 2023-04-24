package calculator;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    public List<Integer> operands;
    public List<Operator> operators;

    public Expression(String stringExpression) {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        var split = stringExpression.split(" ");
        for (int i = 0; i < split.length; ++i) {
            if (i % 2 == 0) {
                operands.add(Integer.parseInt(split[i]));
            } else {
                operators.add(Operator.fromSign(split[i]));
            }
        }
    }
}
