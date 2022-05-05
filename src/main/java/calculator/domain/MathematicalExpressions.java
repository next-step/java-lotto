package calculator.domain;

import utils.ArrayListUtils;

import java.util.ArrayList;
import java.util.List;

public class MathematicalExpressions {
    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int FIRST_OPERAND_INDEX = 0;
    private static final int OPERATOR_INDEX = 1;
    private static final int SECOND_OPERAND_INDEX = 2;
    private static final int MIN_EXPRESSION_SIZE = 3;
    private static final int CALCULATED_SIZE = 1;

    private final List<MathematicalExpression> mathematicalExpressions;

    private MathematicalExpressions(Operand operand, List<MathematicalExpression> mathematicalExpressions) {
        this(ArrayListUtils.join(operand, mathematicalExpressions));
    }

    private MathematicalExpressions(List<MathematicalExpression> mathematicalExpressions) {
        validateMathematicalExpressions(mathematicalExpressions);
        this.mathematicalExpressions = mathematicalExpressions;
    }

    private void validateMathematicalExpressions(List<MathematicalExpression> mathematicalExpressions) {
        if (mathematicalExpressions == null) {
            throw new IllegalArgumentException("mathematicalExpressions은 null일 수 없습니다.");
        }

        if (isEven(mathematicalExpressions.size())) {
            throw new IllegalArgumentException(String.format("수식의 길이(%s)가 올바르지 않습니다.", mathematicalExpressions.size()));
        }
    }

    public static MathematicalExpressions from(List<String> mathematicalExpressions) {
        validateNotNull(mathematicalExpressions);
        List<MathematicalExpression> result = new ArrayList<>();

        for (int i = 0; i < mathematicalExpressions.size(); i++) {
            result.add(toMathematicalExpression(mathematicalExpressions.get(i), i));
        }

        return new MathematicalExpressions(result);
    }

    private static void validateNotNull(List<String> mathematicalExpressions) {
        if (mathematicalExpressions == null) {
            throw new IllegalArgumentException("mathematicalExpressions은 null일 수 없습니다.");
        }
    }

    private static MathematicalExpression toMathematicalExpression(String expression, int index) {
        if (isEven(index)) {
            return new Operand(expression);
        }

        return new Operator(expression);
    }

    private static boolean isEven(int index) {
        return index % TWO == ZERO;
    }

    public int result() {
        return calculate().getFirstOperand().value();
    }

    private MathematicalExpressions calculate() {
        if (this.mathematicalExpressions.size() == CALCULATED_SIZE) {
            return this;
        }

        return new MathematicalExpressions(leftExpressionsResultOperand(), getRightExpressions())
                .calculate();
    }

    private Operand leftExpressionsResultOperand() {
        return getOperator().calculate(
                getFirstOperand(),
                getSecondOperand()
        );
    }

    private List<MathematicalExpression> getRightExpressions() {
        return this.mathematicalExpressions.subList(MIN_EXPRESSION_SIZE, this.mathematicalExpressions.size());
    }

    private Operand getFirstOperand() {
        return (Operand) this.mathematicalExpressions.get(FIRST_OPERAND_INDEX);
    }

    private Operand getSecondOperand() {
        return (Operand) this.mathematicalExpressions.get(SECOND_OPERAND_INDEX);
    }

    private Operator getOperator() {
        return (Operator) this.mathematicalExpressions.get(OPERATOR_INDEX);
    }
}
