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

    public void validate(String[] expression) {
        if (expression == null || expression.length == 0) {
            throw new IllegalArgumentException("수식은 빈 값일 수 없습니다.");
        }

        if (expression.length % 2 == 0) {
            throw new IllegalArgumentException("수식의 길이는 홀수여야 합니다.");
        }

        for (int i = 0; i < expression.length; i++) {
            validateTokenOrder(expression, i);
        }
    }

    private void validateTokenOrder(String[] expression, int i) {
        boolean isEvenIndex = (i % 2 == 0);

        if (isEvenIndex && !isNumber(expression[i])) {
            throw new IllegalArgumentException("숫자가 있어야 할 자리에 연산자가 있습니다: " + expression[i]);
        }

        if (!isEvenIndex && !isOperator(expression[i])) {
            throw new IllegalArgumentException("연산자가 있어야 할 자리에 숫자가 있습니다: " + expression[i]);
        }
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        try {
            Operator.from(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
