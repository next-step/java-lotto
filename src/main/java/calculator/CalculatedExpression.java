package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatedExpression extends Operand {

    public CalculatedExpression(List<Token> left, Operator operator, Operand right) {
        this(CalculatedExpression.calculate(left), operator, right);
    }

    public CalculatedExpression(Operand left, Operator operator, Operand right) {
        super(operator.compute(left, right));
    }

    public static Operand from(String strExpression) {
        List<Token> tokens = Arrays.stream(strExpression.split(" "))
            .map(Token::of)
            .collect(Collectors.toList());
        return calculate(tokens);
    }

    private static Operand calculate(List<Token> tokens) {
        if (tokens.size() == 1) {
            return Operand.of(tokens.get(0));
        }
        return new CalculatedExpression(
            tokens.subList(0, tokens.size() - 2),
            Operator.of(tokens.get(tokens.size() - 2)),
            Operand.of(tokens.get(tokens.size() - 1))
        );
    }

    public int value() {
        return super.value();
    }
}
