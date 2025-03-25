package step1.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expression {
    private final List<String> expression;

    public Expression(List<String> input) {
        this.expression = input;
    }

    public Operands generateOperands() {
        List<Operand> operands = IntStream.range(0, expression.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Operand.from(expression.get(i)))
                .collect(Collectors.toList());
        return new Operands(operands);
    }

    public Operators generateOperators() {
        List<Operator> operators = IntStream.range(0, expression.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> Operator.from(expression.get(i)))
                .collect(Collectors.toList());
        return new Operators(operators);
    }


}
