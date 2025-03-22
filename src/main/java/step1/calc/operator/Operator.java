package step1.calc.operator;

import java.util.Map;
import step1.calc.operand.Operand;
import step1.calc.operation.Operation;
import step1.calc.operation.addition.Addition;
import step1.calc.operation.division.Division;
import step1.calc.operation.multiplication.Multiplication;
import step1.calc.operation.subtraction.Subtraction;

public class Operator {

    private static final Map<String, Operation> OPERATION_MAP = Map.of(
        "+", new Addition(),
        "-", new Subtraction(),
        "*", new Multiplication(),
        "/", new Division()
    );

    private final Operation operation;

    public Operator(String symbol) {
        this.operation = OPERATION_MAP.get(symbol);
        if (this.operation == null) {
            throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol);
        }
    }

    public Operand operate(Operand a, Operand b) {
        return operation.operate(a, b);
    }
}

