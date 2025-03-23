package step1.util;

import step1.domain.Operand;
import step1.domain.Operands;
import step1.domain.Operator;
import step1.domain.Operators;

import java.util.ArrayList;
import java.util.List;

public class ExpressionTokens {

    public static Operands filterOperands(String[] expression) {
        List<Operand> nums = new ArrayList<>();
        for (int i = 0; i < expression.length; i += 2) {
            nums.add(Operand.from(expression[i]));
        }
        return new Operands(nums);
    }

    public static Operators filterOperators(String[] expression) {
        List<Operator> operators = new ArrayList<>();
        for (int i = 1; i < expression.length; i += 2) {
            operators.add(Operator.from(expression[i]));
        }
        return new Operators(operators);
    }
}
