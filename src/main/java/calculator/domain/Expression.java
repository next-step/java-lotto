package calculator.domain;

import java.util.Collections;
import java.util.List;

public class Expression {

    private final List<Operand> operands;
    private final List<Operator> operators;

    Expression(List<Operand> operands, List<Operator> operators) {
        validElementList(operands, operators);
        this.operands = Collections.unmodifiableList(operands);
        this.operators = Collections.unmodifiableList(operators);
    }

    private static void validElementList(List<Operand> operands, List<Operator> operators) {
        if (operands == null || operators == null) {
            throw new IllegalArgumentException("null로 Expression을 생성할 수 없습니다.");
        }
        if (operands.isEmpty()) {
            throw new IllegalArgumentException("Operand는 최소 1개 존재해야 합니다.");
        }
        if (operands.size() - operators.size() != 1) {
            throw new IllegalArgumentException("Operand 개수는 Operator 개수보다 1개 많아야 합니다.");
        }
    }

    public Number calculate() {
        Operand preOperand = this.operands.get(0);
        for (int i = 1; i < this.operands.size() + this.operators.size(); i += 2) {
            Operator operator = operators.get(i / 2);
            Operand postOperand = operands.get((i + 1) / 2);
            Number result = operator.calculate(preOperand, postOperand);
            preOperand = new Operand(result.value());
        }
        return new Number(preOperand.value());
    }
}
