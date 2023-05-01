package calculator.domain;

import java.util.Collections;
import java.util.List;

public class Expression {

    private final List<Operand> operands;
    private final List<Operator> operators;

    public Expression(List<Operand> operands, List<Operator> operators) {
        if (operands == null || operators == null ) {
            throw new IllegalArgumentException("null로 Expression을 생성할 수 없습니다.");
        }
        if (operands.isEmpty()) {
            throw new IllegalArgumentException("Operand는 최소 1개 존재해야 합니다.");
        }
        this.operands = Collections.unmodifiableList(operands);
        this.operators = Collections.unmodifiableList(operators);
    }

    private boolean isEmptyList(List<?> elements) {
        return elements == null || elements.isEmpty();
    }

    public ExpressionElement get(int index) {
        if (index == 0) {
            return operands.get(0);
        }
        if (index % 2 == 1) {
            return operators.get(index / 2);
        }
        return operands.get(index / 2);
    }

    public int size() {
        return this.operands.size() + this.operators.size();
    }
}
