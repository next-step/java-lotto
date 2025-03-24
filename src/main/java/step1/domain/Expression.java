package step1.domain;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final String[] expression;

    public Expression(String input) {
        this.expression = split(input);
        validate(this.expression);
    }

    private String[] split(String input) {
        return input.split(" ");
    }

    public Operands generateOperands() {
        List<Operand> nums = new ArrayList<>();
        for (int i = 0; i < expression.length; i += 2) {
            nums.add(Operand.from(expression[i]));
        }
        return new Operands(nums);
    }

    public Operators generateOperators() {
        List<Operator> operators = new ArrayList<>();
        for (int i = 1; i < expression.length; i += 2) {
            operators.add(Operator.from(expression[i]));
        }
        return new Operators(operators);
    }


}
